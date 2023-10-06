package me.zhenxin.qqbot.websocket

import com.alibaba.fastjson2.parseObject
import com.alibaba.fastjson2.toJSONString
import io.github.oshai.kotlinlogging.KotlinLogging
import me.zhenxin.qqbot.entity.Payload

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
        when (payload.t) {
            "READY" -> event.onReady(payload)
            "RESUMED" -> logger.info { "恢复连接成功，离线事件已处理" }
            else -> logger.warn { "未知事件：${payload.t}" }
        }
    }

    fun onHeartbeat(payload: Payload) {

    }

    fun onReconnect(payload: Payload) {
        logger.info { "收到重连通知，准备重连" }
    }

    fun onInvalidSession(payload: Payload) {

    }

    fun onHello(payload: Payload) {
        val data = payload.d.toJSONString().parseObject()
        client.heartbeatInterval = data.getLong("heartbeat_interval")

        if (client.sessionId.isNotEmpty()) {
            client.sendResume()
        } else {
            client.sendIdentify()
        }

        client.startHeartbeat()
    }

    fun onHeartbeatACK(payload: Payload) {

    }
}