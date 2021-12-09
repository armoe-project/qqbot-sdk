package me.zhenxin.qqbot.pojo;

import lombok.Data;

/**
 * 频道对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 15:44
 */
@Data
public class Guild {
    /**
     * 频道ID
     */
    private String id;
    /**
     * 频道名称
     */
    private String name;
    /**
     * 频道头像地址
     */
    private String icon;
    /**
     * 创建人用户ID
     */
    private String ownerId;
    /**
     * 当前人是否是创建人
     */
    private Boolean owner;
    /**
     * 成员数
     */
    private Integer memberCount;
    /**
     * 最大成员数
     */
    private Integer maxMemberCount;
    /**
     * 简介
     */
    private String description;
    /**
     * 加入时间
     */
    private String joinedAt;
}
