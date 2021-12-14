package me.zhenxin.qqbot.api;

import me.zhenxin.qqbot.entity.Member;
import me.zhenxin.qqbot.exception.ApiException;

/**
 * 成员相关接口
 *
 * @author 真心
 * @email qgzhenxin@qq.com
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
}
