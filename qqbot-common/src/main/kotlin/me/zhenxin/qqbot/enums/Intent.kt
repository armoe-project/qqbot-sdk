package me.zhenxin.qqbot.enums

/**
 * 消息类型
 *
 * @author 真心
 * @since 2023/10/6 0:41
 */

enum class Intent(val value: Int) {
    /**
     * 频道相关事件
     */
    GUILDS(1 shl 0),

    /**
     * 频道成员相关事件
     */
    GUILD_MEMBERS(1 shl 1),

    /**
     * 用户消息事件(私域可用)
     */
    USER_MESSAGES(1 shl 9),

    /**
     * 消息表态相关事件
     */
    GUILD_MESSAGE_REACTIONS(1 shl 10),

    /**
     * 私聊消息相关事件
     */
    DIRECT_MESSAGE(1 shl 12),

    /**
     * 消息审核相关事件
     */
    MESSAGE_AUDIT(1 shl 27),

    /**
     * 论坛相关事件
     */
    FORUM_EVENT(1 shl 28),

    /**
     * 音频相关事件
     */
    AUDIO_ACTION(1 shl 29),

    /**
     * 艾特消息事件
     */
    AT_MESSAGES(1 shl 30);
}