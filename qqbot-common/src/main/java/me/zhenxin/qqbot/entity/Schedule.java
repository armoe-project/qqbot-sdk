package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 日程对象
 *
 * @author 真心
 * @since 2021/12/19 13:12
 */
@Data
public class Schedule {
    /**
     * 日程 id
     */
    private String id;
    /**
     * 日程名称
     */
    private String name;
    /**
     * 日程描述
     */
    private String description;
    /**
     * 日程开始时间戳(ms)
     */
    private String startTimestamp;
    /**
     * 日程结束时间戳(ms)
     */
    private String endTimestamp;
    /**
     * 创建者
     */
    private Member creator;
    /**
     * 日程开始时跳转到的子频道 id
     */
    private String jumpChannelId;
    /**
     * 日程提醒类型
     */
    private String remindType;
}
