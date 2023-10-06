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

val logger = KotlinLogging.logger {}

/**
 * 基本接口
 *
 * @author 真心
 * @since 2023/10/3 20:38
 */
abstract class OpenApi(accessInfo: AccessInfo) {
    private val base = if (accessInfo.isSandbox) "https://sandbox.api.sgroup.qq.com" else "https://api.sgroup.qq.com"
    private val botAppId = accessInfo.botAppId
    private val botToken = accessInfo.botToken

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
        val body = response.body?.string()
            ?: throw RuntimeException("HTTP Request failed with code ${response.code}, message: ${response.message}")

        logger.debug { "HTTP Response: ${response.code} ${response.message}" }
        logger.debug { "HTTP Response Body: $body" }

        if (response.code != 200) {
            throw ApiException(
                response.code,
                body,
                response.headers["X-Trace-Id"] ?: "N/A"
            )
        }

        return JSON.to(clazz, body)
            ?: throw RuntimeException("JSON parse failed, body: $body")
    }

    private fun Request.Builder.addBotHeader(): Request.Builder {
        addHeader("User-Agent", "qqbot-sdk/2.0.0-dev")
        addHeader("Authorization", "Bot $botAppId.$botToken")
        return this
    }

}