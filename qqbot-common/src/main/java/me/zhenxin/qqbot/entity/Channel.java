package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 子频道对象
 *
 * @author 真心
 * @since 2021/12/11 12:53
 */
@Data
public class Channel {
    /**
     * 子频道ID
     */
    private String id;
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道名称
     */
    private String name;
    /**
     * 子频道类型
     */
    private Integer type;
    /**
     * 子频道子类型
     */
    private Integer subType;
    /**
     * 排序 (必填，而且不能够和其他子频道的值重复)
     */
    private Integer position;
    /**
     * 分组ID
     */
    private String parentId;
    /**
     * 创建人ID
     */
    private String ownerId;
}
