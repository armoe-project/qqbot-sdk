package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 表态对象
 *
 * @author 真心
 * @since 2021/12/19 12:51
 */
@Data
public class ReactionTarget {
    /**
     * 表态对象ID
     */
    private String id;
    /**
     * 表态对象类型
     */
    private Integer type;
}
