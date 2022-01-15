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
import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.Guild;
import me.zhenxin.qqbot.entity.Member;
import me.zhenxin.qqbot.exception.ApiException;

import java.util.List;

/**
 * 频道相关接口
 *
 * @author 真心
 * @since 2021/12/11 10:56
 */
public class GuildApi extends BaseApi {
    public GuildApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 获取频道信息
     *
     * @param guildId 频道ID
     */
    public Guild getGuildInfo(String guildId) throws ApiException {
        return get("/guilds/" + guildId, Guild.class);
    }

    /**
     * 获取频道成员列表 (仅私域可用)
     *
     * @param guildId 频道ID
     * @param limit   返回的成员数量 (1-1000)
     */
    public List<Member> getGuildMembers(String guildId, Integer limit) throws ApiException {
        JSONArray array = get("/guilds/" + guildId + "/members?limit=" + limit, JSONArray.class);
        return array.toJavaList(Member.class);
    }

    /**
     * 获取频道成员列表 (仅私域可用)
     *
     * @param after 上一次请求返回的最后一个成员的ID
     * @param limit 返回的成员数量 (1-1000)
     */
    public List<Member> getGuildMembers(String guildId, String after, Integer limit) throws ApiException {
        JSONArray array = get("/guilds/" + guildId + "/members?after=" + after + "&limit=" + limit, JSONArray.class);
        return array.toJavaList(Member.class);
    }
}
