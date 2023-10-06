package me.zhenxin.qqbot.entity

/**
 * 机器人 WebSocket 消息载荷
 *
 * @author 真心
 * @since 2023/10/5 22:27
 */
data class Payload(
    /**
     * 操作
     */
    val op: Int = 0,
    /**
     * 数据
     */
    val d: Any = Any(),
    /**
     * 序号
     */
    val s: Long? = null,
    /**
     * 事件
     */
    val t: String? = null
)
