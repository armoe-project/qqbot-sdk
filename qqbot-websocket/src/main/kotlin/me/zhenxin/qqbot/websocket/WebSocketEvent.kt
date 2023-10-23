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

package me.zhenxin.qqbot.websocket

import com.alibaba.fastjson2.parseObject
import com.alibaba.fastjson2.to
import com.alibaba.fastjson2.toJSONString
import io.github.oshai.kotlinlogging.KotlinLogging
import me.zhenxin.qqbot.entity.Payload
import me.zhenxin.qqbot.entity.User

private val logger = KotlinLogging.logger {}

/**
 * WebSocket 事件
 *
 * @author 真心
 * @since 2023/10/6 1:17
 */
class WebSocketEvent(
    private val client: WebSocketClient
) {
    fun onReady(payload: Payload) {
        val data = payload.data.toJSONString().parseObject()
        val sessionId = data.getString("session_id")
        client.sessionId = sessionId

        val user = data.getString("user").to<User>()
        val username = user.username
        logger.info { "机器人 $username 已上线，会话ID：$sessionId" }
    }

}