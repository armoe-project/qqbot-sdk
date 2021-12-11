package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 消息 Embed 对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:20
 */
@Data
public class MessageEmbed {
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 消息弹窗内容
     */
    private String prompt;
    /**
     * 消息创建时间
     */
    private Long timestamp;
    /**
     * MessageEmbedField 对象数组
     */
    private MessageEmbedField[] fields;
}
