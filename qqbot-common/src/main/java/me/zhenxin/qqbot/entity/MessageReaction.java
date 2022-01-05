package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 表情表态对象
 *
 * @author 真心
 * @since 2021/12/19 12:47
 */
@Data
public class MessageReaction {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 表态对象
     */
    private ReactionTarget target;
    /**
     * 表态所用表情
     */
    private Emoji emoji;
}
