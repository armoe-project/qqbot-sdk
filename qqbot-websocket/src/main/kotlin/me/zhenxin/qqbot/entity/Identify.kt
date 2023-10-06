package me.zhenxin.qqbot.entity

/**
 * WebSocket 鉴权信息
 *
 * @author 真心
 * @since 2023/10/6 0:31
 */
data class Identify(
    /**
     * Token
     */
    var token: String,
    /**
     * 订阅事件
     */
    var intents: Int,
    /**
     * 分片数量
     */
    val shard: List<Int> = listOf(0, 1),
    /**
     * 配置信息
     */
    val properties: Map<String, String> = mapOf()
)
