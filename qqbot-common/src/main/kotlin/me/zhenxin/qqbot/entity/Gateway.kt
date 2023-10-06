package me.zhenxin.qqbot.entity

/**
 * 网关
 *
 * @author 真心
 * @since 2023/10/3 21:03
 */
data class Gateway(
    /**
     * WebSocket 的连接地址
     */
    var url: String = "",
    /**
     * 建议 Shard 数量
     */
    var shards: Int = 1,
    /**
     * Session 限制信息
     */
    var sessionStartLimit: SessionStartLimit = SessionStartLimit(),
)

/**
 * Session 限制信息
 */
data class SessionStartLimit(
    /**
     * 总数
     */
    var total: Int = 0,
    /**
     * 剩余
     */
    var remaining: Int = 0,
    /**
     * 重置时间
     */
    var resetAfter: Int = 0,
    /**
     * 最大并发数
     */
    var maxConcurrency: Int = 0,
)
