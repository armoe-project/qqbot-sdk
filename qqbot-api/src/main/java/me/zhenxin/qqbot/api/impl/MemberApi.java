package me.zhenxin.qqbot.api.impl;

import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.Member;
import me.zhenxin.qqbot.exception.ApiException;

/**
 * 成员相关接口
 *
 * @author 真心
 * @since 2021/12/11 13:11
 */
public class MemberApi extends BaseApi {
    public MemberApi(Boolean isSandBoxMode, String token) throws ApiException {
        super(isSandBoxMode, token);
    }

    /**
     * 获取成员信息
     *
     * @param guildId 频道ID
     * @param userId  用户ID
     */
    public Member getMemberInfo(String guildId, String userId) throws ApiException {
        return get("/guilds/" + guildId + "/members/" + userId, Member.class);
    }

    /**
     * 删除频道成员 (仅私域可用)
     *
     * @param guildId 频道ID
     * @param userId  用户ID
     */
    public void deleteMember(String guildId, String userId) throws ApiException {
        delete("/guilds/" + guildId + "/members/" + userId, null);
    }
}
