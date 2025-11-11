/*
 * QQBot SDK - QQ Official Bot SDK
 * Copyright (C) 2023 ZhenXin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.zhenxin.qqbot.api

import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.toJSONString
import io.github.oshai.kotlinlogging.KotlinLogging
import me.zhenxin.qqbot.entity.AccessInfo
import me.zhenxin.qqbot.exception.ApiException
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.time.LocalDateTime

val logger = KotlinLogging.logger {}

/**
 * 基本接口
 *
 * @author 真心
 * @since 2023/10/3 20:38
 */
@Suppress("unused")
abstract class OpenApi(accessInfo: AccessInfo) {
    private val base = if (accessInfo.isSandbox) "https://sandbox.api.sgroup.qq.com" else "https://api.sgroup.qq.com"
    private val botAppId = accessInfo.botAppId
    private val botToken = accessInfo.botToken
    private val botSecret = accessInfo.botSecret

    private var accessToken = ""
    private var expireTime = LocalDateTime.now()

    private val client = OkHttpClient()

    protected fun <T> get(url: String, clazz: Class<T>): T {
        val request = Request.Builder().url(base + url).get().addBotHeader().build()
        return request(request, clazz)
    }

    protected fun <T> post(url: String, data: Map<String, Any>, clazz: Class<T>): T {
        val builder = Request.Builder().url(base + url)
        val body = requestBody(data)
        val request = builder.post(body).addBotHeader().build()
        return request(request, clazz)
    }

    protected fun <T> put(url: String, data: Map<String, Any>, clazz: Class<T>): T {
        val builder = Request.Builder().url(base + url)
        val body = requestBody(data)
        val request = builder.put(body).addBotHeader().build()
        return request(request, clazz)
    }

    protected fun <T> delete(url: String, clazz: Class<T>): T {
        val request = Request.Builder().url(base + url).delete().addBotHeader().build()
        return request(request, clazz)
    }

    protected fun <T> patch(url: String, data: Map<String, Any>, clazz: Class<T>): T {
        val builder = Request.Builder().url(base + url)
        val body = requestBody(data)
        val request = builder.patch(body).addBotHeader().build()
        return request(request, clazz)
    }

    private fun requestBody(data: Map<String, Any>): RequestBody {
        val json = data.toJSONString()
        val mediaType = "application/json; charset=utf-8".toMediaType()
        return json.toRequestBody(mediaType)
    }


    private fun <T> request(request: Request, clazz: Class<T>): T {
        logger.debug { "HTTP Request: ${request.method} ${request.url}" }
        if (request.body != null) {
            logger.debug { "HTTP Request Body: ${request.body}" }
        }

        val call = client.newCall(request)
        val response = call.execute()
        val body = response.body.string()

        logger.debug { "HTTP Response: ${response.code} ${response.message}" }
        logger.debug { "HTTP Response Body: $body" }

        if (response.code != 200) {
            throw ApiException(
                response.code,
                body,
                response.headers["X-Tps-trace-ID"] ?: "N/A"
            )
        }

        return JSON.to(clazz, body)
            ?: throw RuntimeException("JSON parse failed, body: $body")
    }

    private fun Request.Builder.addBotHeader(): Request.Builder {
        if (accessToken.isBlank() || LocalDateTime.now() > expireTime) {
            refreshAccessToken()
        }

        addHeader("User-Agent", "qqbot-sdk/2.0.0-dev")
        addHeader("Authorization", "Bot $accessToken")
        return this
    }

    private fun refreshAccessToken() {
        val url = "https://bots.qq.com/app/getAppAccessToken"
        val data = mapOf(
            "appId" to botAppId,
            "clientSecret" to botSecret
        )
        val builder = Request.Builder().url(url)
        val requestBody = requestBody(data)
        val request = builder.post(requestBody).build()
        val call = client.newCall(request)
        val response = call.execute()
        val body = response.body.string()
        logger.debug { "HTTP Response: ${response.code} ${response.message}" }
        logger.debug { "HTTP Response Body: $body" }
        val json = JSON.parseObject(body)

        val code = json.getInteger("code")
        if (code != 0) {
            throw ApiException(
                code,
                json.getString("message"),
                response.headers["X-Tps-trace-ID"] ?: "N/A"
            )
        }
        val accessToken = json.getString("access_token")
        this.accessToken = accessToken
        val expireIn = json.getLong("expires_in")
        val expireTime = LocalDateTime.now().plusSeconds(expireIn)
        this.expireTime = expireTime
        logger.debug { "accessToken: $accessToken, expireIn: $expireIn, expireTime: $expireTime" }
    }
}