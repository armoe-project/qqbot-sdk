package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 音频操作
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2022/9/24 10:52
 */
@Data
public class AudioAction {
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 音频URL status为0时传
     */
    private String audioUrl;
    /**
     * 状态文本, 可选，status为0时传，其他操作不传
     */
    private String text;
}
