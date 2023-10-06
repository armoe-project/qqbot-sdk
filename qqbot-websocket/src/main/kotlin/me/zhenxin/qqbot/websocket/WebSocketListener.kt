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
        when (payload.t) {
            "READY" -> event.onReady(payload)
            "RESUMED" -> logger.info { "恢复连接成功，离线事件已处理" }
            else -> logger.warn { "未知事件：${payload.t}" }
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
        val data = payload.d.toJSONString().parseObject()
        client.heartbeatInterval = data.getLong("heartbeat_interval")

        if (client.sessionId.isNotEmpty()) {
            client.sendResume()
        } else {
            client.sendIdentify()
        }

        client.startHeartbeat()
    }
}