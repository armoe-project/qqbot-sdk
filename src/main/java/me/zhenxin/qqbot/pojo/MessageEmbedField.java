package me.zhenxin.qqbot.pojo;

import lombok.Data;

/**
 * 消息 EmbedField 对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:21
 */
@Data
public class MessageEmbedField {
    /**
     * 字段名
     */
    private String name;
    /**
     * 字段值
     */
    private String value;
}
