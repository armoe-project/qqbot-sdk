/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
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

package me.zhenxin.qqbot.api.impl;

import com.alibaba.fastjson.JSONArray;
import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.Schedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日程相关接口
 *
 * @author 真心
 * @since 2021/12/19 13:22
 */
public class ScheduleApi extends BaseApi {
    public ScheduleApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 获取日程列表
     *
     * @param channelId 子频道ID
     * @param since     起始时间 可为null
     * @return 日程对象数组
     */
    public List<Schedule> getScheduleList(String channelId, Long since) {
        JSONArray arr;
        if (since == null) {
            arr = get("/channels/" + channelId + "/schedules", JSONArray.class);
        } else {
            arr = get("/channels/" + channelId + "/schedules?since=" + since, JSONArray.class);
        }
        return arr.toJavaList(Schedule.class);
    }

    /**
     * 获取日程信息
     *
     * @param channelId  子频道ID
     * @param scheduleId 日程ID
     * @return 日程对象
     */
    public Schedule getScheduleInfo(String channelId, String scheduleId) {
        return get("/channels/" + channelId + "/schedules/" + scheduleId, Schedule.class);
    }

    /**
     * 创建日程
     *
     * @param channelId 子频道ID
     * @param schedule  日程对象
     * @return 日程对象
     */
    public Schedule createSchedule(String channelId, Schedule schedule) {
        Map<String, Object> data = new HashMap<>();
        data.put("schedule", schedule);
        return post("/channels/" + channelId + "/schedules", data, Schedule.class);
    }

    /**
     * 更改日程
     *
     * @param channelId 子频道ID
     * @param schedule  日程对象
     * @return 日程对象
     */
    public Schedule changeSchedule(String channelId, Schedule schedule) {
        Map<String, Object> data = new HashMap<>();
        data.put("schedule", schedule);
        return patch("/channels/" + channelId + "/schedules/" + schedule.getId(), data, Schedule.class);
    }

    /**
     * 删除日程
     *
     * @param channelId  子频道ID
     * @param scheduleId 日程ID
     */
    public void deleteSchedule(String channelId, String scheduleId) {
        delete("/channels/" + channelId + "/schedules/" + scheduleId, null);
    }
}
