package me.zhenxin.qqbot.api;

import com.alibaba.fastjson.JSONArray;
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
    public ScheduleApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
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

    public Schedule createSchedule(String channelId, Schedule schedule) {
        Map<String, Object> data = new HashMap<>();
        data.put("schedule", schedule);
        return post("/channels/" + channelId + "/schedules", data, Schedule.class);
    }

    public Schedule changeSchedule(String channelId, Schedule schedule) {
        Map<String, Object> data = new HashMap<>();
        data.put("schedule", schedule);
        return patch("/channels/" + channelId + "/schedules/" + schedule.getId(), data, Schedule.class);
    }

    public void deleteSchedule(String channelId, String scheduleId) {
        delete("/channels/" + channelId + "/schedules/" + scheduleId, null, null);
    }
}
