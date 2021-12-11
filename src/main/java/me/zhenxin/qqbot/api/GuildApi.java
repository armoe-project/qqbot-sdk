package me.zhenxin.qqbot.api;

import cn.hutool.json.JSONUtil;
import me.zhenxin.qqbot.entity.Guild;

/**
 * 频道相关接口
 *
 * @author 真心
 * @email qgzhenxin@qq.com
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
    public Guild getGuildInfo(String guildId) {
        String result = get("/guilds/" + guildId);
        return JSONUtil.toBean(result, Guild.class);
    }
}
