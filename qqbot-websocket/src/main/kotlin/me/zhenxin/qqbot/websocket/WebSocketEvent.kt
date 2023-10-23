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
import com.alibaba.fastjson2.toJSONString
import io.github.oshai.kotlinlogging.KotlinLogging
import me.zhenxin.qqbot.entity.Channel
import me.zhenxin.qqbot.entity.Guild
import me.zhenxin.qqbot.entity.Payload
import me.zhenxin.qqbot.entity.Ready

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
        val ready = payload.data<Ready>()
        client.sessionId = ready.sessionId
        logger.info { "机器人 ${ready.user.username} 已上线，会话ID：${ready.sessionId}" }
    }

    fun onGuildCreate(payload: Payload) {
        val guild = payload.data<Guild>()
        logger.info { "[频道加入] ${guild.name}(${guild.id})" }
    }

    fun onGuildUpdate(payload: Payload) {
        val guild = payload.data<Guild>()
        logger.info { "[频道更新] ${guild.name}(${guild.id})" }
    }

    fun onGuildDelete(payload: Payload) {
        val guild = payload.data<Guild>()
        logger.info { "[频道退出] ${guild.name}(${guild.id})" }
    }

    fun onChannelCreate(payload: Payload) {
        val channel = payload.data<Channel>()
        logger.info { "[子频道创建] ${channel.name}(${channel.id})" }
    }

    fun onChannelUpdate(payload: Payload) {
        val channel = payload.data<Channel>()
        logger.info { "[子频道更新] ${channel.name}(${channel.id})" }
    }

    fun onChannelDelete(payload: Payload) {
        val channel = payload.data<Channel>()
        logger.info { "[子频道删除] ${channel.name}(${channel.id})" }
    }

    private inline fun <reified T> Payload.data(): T {
        val data = this.data.toJSONString().parseObject<T>()
        logger.debug { "事件数据：$data" }
        return data
    }
}