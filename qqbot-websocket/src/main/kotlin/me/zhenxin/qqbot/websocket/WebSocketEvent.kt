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
        val data = payload.d.toJSONString().parseObject()
        val sessionId = data.getString("session_id")
        client.sessionId = sessionId

        val user = data.getString("user").to<User>()
        val username = user.username
        logger.info { "机器人 $username 已上线，会话ID：$sessionId" }
    }

}