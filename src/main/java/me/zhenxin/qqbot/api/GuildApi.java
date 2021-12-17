package me.zhenxin.qqbot.api;

import me.zhenxin.qqbot.entity.Guild;
import me.zhenxin.qqbot.exception.ApiException;

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
}
