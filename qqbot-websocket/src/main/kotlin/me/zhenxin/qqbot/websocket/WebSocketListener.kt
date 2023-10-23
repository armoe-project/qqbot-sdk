/*
 * QQBot SDK - QQ Official Bot SDK For Java
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

package me.zhenxin.qqbot.websocket

import com.alibaba.fastjson2.parseObject
import com.alibaba.fastjson2.toJSONString
import io.github.oshai.kotlinlogging.KotlinLogging
import me.zhenxin.qqbot.entity.Payload
import kotlin.system.exitProcess

private val logger = KotlinLogging.logger {}

/**
 * WebSocket 监听器
 *
 * @author 真心
 * @since 2023/10/5 23:10
 */
class WebSocketListener(
    private val client: WebSocketClient
) {
    private val event = WebSocketEvent(client)

    fun onDispatch(payload: Payload) {
        when (payload.type) {
            "READY" -> event.onReady(payload)
            "RESUMED" -> logger.info { "恢复连接成功，离线事件已处理" }
            else -> logger.warn { "未知事件：${payload.type}" }
        }
    }

    fun onReconnect() {
        logger.info { "服务端下发重连通知，准备开始重连" }
    }

    fun onInvalidSession() {
        logger.warn { "鉴权失败！请检查 AccessInfo 是否正确，并查看是否注册了正确的 Intent" }
        exitProcess(9)
    }

    fun onHello(payload: Payload) {
        val data = payload.data.toJSONString().parseObject()
        client.heartbeatInterval = data.getLong("heartbeat_interval")

        if (client.sessionId.isNotEmpty()) {
            client.sendResume()
        } else {
            client.sendIdentify()
        }

        client.startHeartbeat()
    }
}