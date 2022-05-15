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

package me.zhenxin.qqbot.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.forum.thread.Thread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 帖子API
 *
 * @author 真心
 * @since 2022/5/15 13:23
 */
public class ForumApi extends BaseApi {
    public ForumApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 获取帖子列表
     *
     * @param channelId 子频道ID
     * @return {@link Thread} 列表
     */
    public List<Thread> getThreadList(String channelId) {
        JSONObject obj = get("/channels/" + channelId + "/threads", JSONObject.class);
        JSONArray array = obj.getJSONArray("threads");
        return array.toJavaList(Thread.class);
    }

    /**
     * 获取帖子详情
     *
     * @param channelId 子频道ID
     * @param threadId  帖子ID
     * @return {@link Thread} 对象
     */
    public Thread getThreadInfo(String channelId, String threadId) {
        JSONObject obj = get("/channels/" + channelId + "/threads/" + threadId, JSONObject.class);
        return obj.getJSONObject("thread").toJavaObject(Thread.class);
    }

    /**
     * 发布帖子
     *
     * @param channelId 子频道ID
     * @param title     帖子标题
     * @param content   帖子内容
     * @param format    帖子文本格式 <a href="https://bot.q.qq.com/wiki/develop/api/openapi/forum/put_thread.html#format">官方文档</a>
     */
    public void publishThread(String channelId, String title, String content, int format) {
        Map<String, Object> data = new HashMap<>();
        data.put("title", title);
        data.put("content", content);
        data.put("format", format);
        put("/channels/" + channelId + "/threads", data, null);
    }

    /**
     * 删除帖子
     *
     * @param channelId 子频道ID
     * @param threadId  帖子ID
     */
    public void deleteThread(String channelId, String threadId) {
        delete("/channels/" + channelId + "/threads/" + threadId, null);
    }
}
