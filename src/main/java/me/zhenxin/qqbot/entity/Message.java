package me.zhenxin.qqbot.entity;

import lombok.Data;
import me.zhenxin.qqbot.entity.ark.MessageArk;

/**
 * 消息对象
 *
 * @author 真心
 * @since 2021/12/8 16:16
 */
@Data
public class Message {
    /**
     * 消息ID
     */
    private String id;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息创建时间
     */
    private Long timestamp;
    /**
     * 消息编辑时间
     */
    private Long editedTimestamp;
    /**
     * 是否为 @全体成员 消息
     */
    private Boolean mentionEveryone;
    /**
     * 消息创建人
     */
    private User author;
    /**
     * 消息附件
     */
    private MessageAttachment[] attachments;
    /**
     * Embed
     */
    private MessageEmbed[] embeds;
    /**
     * 消息中@的人
     */
    private User[] mentions;
    /**
     * 消息创建者的信息
     */
    private Member member;
    /**
     * Ark消息
     */
    private MessageArk ark;
}
