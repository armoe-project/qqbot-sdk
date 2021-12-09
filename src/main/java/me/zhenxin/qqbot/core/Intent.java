package me.zhenxin.qqbot.core;

import lombok.Getter;

/**
 * Intents
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 0:37
 */
@Getter
public enum Intent {
    /**
     * 频道相关事件
     */
    GUILDS(1),
    /**
     * 频道成员相关事件
     */
    GUILD_MEMBERS(1 << 1),
    /**
     * 全部消息事件
     */
    MESSAGES(1 << 9),
    /**
     * 消息表态相关事件
     */
    GUILD_MESSAGE_REACTIONS(1 << 10),
    /**
     * 私聊消息相关事件
     */
    DIRECT_MESSAGE(1 << 12),
    /**
     * 音频相关事件
     */
    AUDIO_ACTION(1 << 29),
    /**
     * 艾特消息事件
     */
    AT_MESSAGES(1 << 30);
    private Integer value;

    Intent(Integer value) {
        this.value = value;
    }
}
