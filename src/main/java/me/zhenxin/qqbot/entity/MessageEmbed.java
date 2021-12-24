package me.zhenxin.qqbot.entity;

import lombok.Data;

import java.util.List;

/**
 * 消息 Embed 对象
 *
 * @author 真心
 * @since 2021/12/8 16:20
 */
@Data
public class MessageEmbed {
    /**
     * 标题
     */
    private String title;
    /**
     * 消息弹窗内容
     */
    private String prompt;
    /**
     * 缩略图
     */
    private MessageEmbedThumbnail thumbnail;
    /**
     * MessageEmbedField 对象数组
     */
    private List<MessageEmbedField> fields;
}
