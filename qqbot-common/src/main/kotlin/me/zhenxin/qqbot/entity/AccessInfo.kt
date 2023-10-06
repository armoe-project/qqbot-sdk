package me.zhenxin.qqbot.entity

/**
 * 访问信息
 *
 * @author 真心
 * @since 2023/10/1 23:55
 */
data class AccessInfo(
    /**
     * 管理端的 BotAppID
     */
    var botAppId: Int = 0,
    /**
     * 管理端的 机器人令牌
     */
    var botToken: String = "",
    /**
     * 管理端的 机器人密钥
     */
    var botSecret: String = "",
    /**
     * 是否使用沙箱环境
     */
    var isSandbox: Boolean = false
)