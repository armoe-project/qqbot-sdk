/*
 * qq-official-bot-sdk - QQ Official Bot SDK For Java
 * Copyright (C) 2021-2022 xiaoye-bot Project Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
