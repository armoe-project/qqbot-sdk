package me.zhenxin.qqbot.api;

import cn.hutool.json.JSONUtil;
import me.zhenxin.qqbot.pojo.Member;

/**
 * 成员相关接口
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/11 13:11
 */
public class MemberApi extends BaseApi {
    public MemberApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
    }

    /**
     * 获取成员信息
     *
     * @param guildId 频道ID
     * @param userId  用户ID
     */
    public Member getMemberInfo(String guildId, String userId) {
        String result = get("/guilds/" + guildId + "/members/" + userId);
        return JSONUtil.toBean(result, Member.class);
    }
}
