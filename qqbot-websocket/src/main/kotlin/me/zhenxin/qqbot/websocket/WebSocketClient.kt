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

import com.alibaba.fastjson2.to
import com.alibaba.fastjson2.toJSONString
import io.github.oshai.kotlinlogging.KotlinLogging
import me.zhenxin.qqbot.entity.AccessInfo
import me.zhenxin.qqbot.entity.Identify
import me.zhenxin.qqbot.entity.Payload
import me.zhenxin.qqbot.entity.Resume
import me.zhenxin.qqbot.enums.Intent
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import java.util.*


private val logger = KotlinLogging.logger {}

/**
 * WebSocket 客户端
 *
 * @author 真心
 * @since 2023/10/5 21:46
 */
class WebSocketClient(
    serverUri: URI?,
    private val accessInfo: AccessInfo,
    private var intents: MutableList<Intent>
) : WebSocketClient(serverUri) {
    private val token = "Bot ${accessInfo.botAppId}.${accessInfo.botToken}"
    private var heartbeatTimer: Timer? = null

    private var sequence: Long = 0

    var sessionId: String = ""
    var heartbeatInterval: Long = 0

    override fun onOpen(handshakedata: ServerHandshake?) {
        Thread.currentThread().name = "websocket"
        val status = "${handshakedata?.httpStatus} ${handshakedata?.httpStatusMessage}"
        logger.info { "已连接至网关，状态：$status" }
    }

    override fun send(text: String?) {
        logger.debug { "发送消息：$text" }
        super.send(text)
    }

    override fun onMessage(message: String?) {
        logger.debug { "收到消息：$message" }
        val payload = message.to<Payload>() ?: return
        val listener = WebSocketListener(this)

        if (payload.seq != null) {
            sequence = payload.seq
        }

        when (payload.op) {
            0 -> listener.onDispatch(payload) // 事件分发
            10 -> listener.onHello(payload) // 连接成功之后，会收到该消息
            7 -> listener.onReconnect() // 重连通知
            9 -> listener.onInvalidSession() // 鉴权失败
        }
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        when (code) {
            4001 -> logger.info { "连接已关闭，错误码：$code，原因：无效的操作码(op)" }
            4002 -> logger.info { "连接已关闭，错误码：$code，原因：无效的 Payload 数据($reason)" }
            4007 -> logger.info { "连接已关闭，错误码：$code，原因：无效的序号($reason)" }
            4008 -> logger.info { "连接已关闭，错误码：$code，原因：发送 Payload 太快($reason)" }
            4009 -> logger.info { "连接已关闭，错误码：$code，原因：连接已过期，需要重新连接($reason)" }
            4010 -> logger.info { "连接已关闭，错误码：$code，原因：无效的 Shard 数据($reason)" }
            4011 -> logger.info { "连接已关闭，错误码：$code，原因：连接需要处理过多的事件，请使用分片($reason)" }
            4012 -> logger.info { "连接已关闭，错误码：$code，原因：无效的版本($reason)" }
            4013 -> logger.info { "连接已关闭，错误码：$code，原因：无效的 Intents 数据($reason)" }
            4014 -> logger.info { "连接已关闭，错误码：$code，原因：订阅的 Intents 没有权限($reason)" }
            4914 -> logger.info { "连接已关闭，错误码：$code，原因：机器人已下架，只允许使用沙箱环境($reason)" }
            4915 -> logger.info { "连接已关闭，错误码：$code，原因：机器人已被封禁，不允许连接($reason)" }
            else -> logger.info { "连接已关闭，错误码：$code，原因：$reason，是否远程：$remote" }
        }
        logger.info { "5 秒后开始尝试重新连接..." }
        Thread.sleep(5000)
        reconnect(code)
    }

    override fun onError(ex: Exception?) {
        logger.error(ex) { "连接出现异常，错误信息：${ex?.localizedMessage}" }
    }

    private fun reconnect(code: Int) {
        logger.info { "正在重新连接..." }
        if (code != 4009) sessionId = ""
        val thread = Thread {
            Thread.currentThread().name = "websocket"
            reconnect()
        }
        thread.start()
    }

    fun startHeartbeat() {
        if (heartbeatTimer != null) heartbeatTimer?.cancel()
        heartbeatTimer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                Thread.currentThread().name = "heartbeat"
                sendHeartbeat()
            }
        }
        heartbeatTimer?.schedule(task, 0, heartbeatInterval)
    }

    private fun sendHeartbeat() {
        val payload = Payload(
            op = 1,
            data = sequence
        )
        send(payload.toJSONString())
    }

    fun sendIdentify() {
        logger.info { "正在发送鉴权信息..." }
        var intentsNum = 0
        for (intent in intents) {
            intentsNum = intentsNum or intent.value
        }
        val identify = Identify(
            token = token,
            intents = intentsNum,
        )
        val payload = Payload(
            op = 2,
            data = identify
        )
        send(payload.toJSONString())
    }

    fun sendResume() {
        logger.info { "正在发送恢复信息..." }
        val resume = Resume(
            token = token,
            sessionId = sessionId,
            seq = sequence
        )
        val payload = Payload(
            op = 6,
            data = resume
        )
        send(payload.toJSONString())
    }
}