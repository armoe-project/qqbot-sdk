package me.zhenxin.qqbot

import io.github.oshai.kotlinlogging.KotlinLogging
import me.zhenxin.qqbot.api.ApiManager
import me.zhenxin.qqbot.entity.AccessInfo
import me.zhenxin.qqbot.enums.Intent
import me.zhenxin.qqbot.websocket.WebSocketClient
import java.net.URI

val logger = KotlinLogging.logger {}

/**
 * Bot 核心
 *
 * @author 真心
 * @since 2023/10/5 22:38
 */
class BotCore(private val accessInfo: AccessInfo) {
    private var intents: MutableList<Intent> = mutableListOf()
    private var shards: Int = 1

    fun start() {
        val url = getGatewayUrl()
        logger.info { "正在连接至网关：$url" }
        for (i in 0 until shards) {
            val uri = URI(url)
            val client = WebSocketClient(uri, accessInfo, intents)
            client.connect()
        }
    }

    fun getApiManager(): ApiManager {
        return ApiManager(accessInfo)
    }

    private fun getGatewayUrl(): String {
        val api = getApiManager().getGatewayApi()
        val gateway = api.getBotGateway()
        shards = gateway.shards
        return gateway.url
    }

    fun registerIntents(vararg intents: Intent) {
        this.intents.addAll(intents)
    }
}