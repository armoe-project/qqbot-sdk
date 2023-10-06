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
     * 频道消息事件 (仅私域可用)
     */
    GUILD_MESSAGES(1 shl 9),

    /**
     * 消息表态相关事件
     */
    GUILD_MESSAGE_REACTIONS(1 shl 10),

    /**
     * 私聊消息相关事件
     */
    DIRECT_MESSAGE(1 shl 12),

    /**
     * 论坛相关事件 (公域可用)
     */
    OPEN_FORUMS_EVENTS(1 shl 18),

    /**
     * 音视频/直播子频道相关事件
     */
    AUDIO_OR_LIVE_CHANNEL_MEMBERS(1 shl 19),

    /**
     * 互动相关事件
     */
    INTERACTION(1 shl 26),

    /**
     * 消息审核相关事件
     */
    MESSAGE_AUDIT(1 shl 27),

    /**
     * 论坛相关事件 (私域可用)
     */
    FORUM_EVENT(1 shl 28),

    /**
     * 音频相关事件
     */
    AUDIO_ACTION(1 shl 29),

    /**
     * 频道消息事件 (公域可用)
     */
    PUBLIC_GUILD_MESSAGES(1 shl 30);
}