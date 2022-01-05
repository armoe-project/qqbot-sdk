package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 表情对象
 *
 * @author 真心
 * @since 2021/12/19 12:50
 */
@Data
public class Emoji {
    /**
     * 表情ID
     */
    private String id;
    /**
     * 表情类型
     */
    private Integer type;
}
