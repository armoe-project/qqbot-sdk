package me.zhenxin.qqbot.api.impl;

import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 禁言相关接口
 *
 * @author 真心
 * @since 2021/12/24 12:21
 */
public class MuteApi extends BaseApi {
    public MuteApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 全员禁言
     *
     * @param guildId  频道ID
     * @param duration 禁言时长，单位秒，0为解除禁言
     */
    public void muteAll(String guildId, Integer duration) {
        Map<String, Object> data = new HashMap<>();
        data.put("mute_seconds", duration.toString());
        patch("/guilds/" + guildId + "/mute", data, null);
    }

    /**
     * 禁言
     *
     * @param guildId  频道ID
     * @param userId   用户ID
     * @param duration 禁言时长，单位秒，0为解除禁言
     */
    public void mute(String guildId, String userId, Integer duration) {
        Map<String, Object> data = new HashMap<>();
        data.put("mute_seconds", duration.toString());
        patch("/guilds/" + guildId + "/members/" + userId + "/mute", data, null);
    }
}
