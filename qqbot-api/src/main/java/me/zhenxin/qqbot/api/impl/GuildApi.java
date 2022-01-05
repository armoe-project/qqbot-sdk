package me.zhenxin.qqbot.api.impl;

import com.alibaba.fastjson.JSONArray;
import me.zhenxin.qqbot.api.BaseApi;
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
    public GuildApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
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
