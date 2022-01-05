package me.zhenxin.qqbot.api;

import com.alibaba.fastjson.JSONArray;
import me.zhenxin.qqbot.entity.Channel;

import java.util.List;

/**
 * 子频道相关接口
 *
 * @author 真心
 * @since 2021/12/19 13:43
 */
public class ChannelApi extends BaseApi {
    public ChannelApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
    }

    /**
     * 获取子频道信息
     *
     * @param channelId 子频道ID
     * @return 子频道对象
     */
    public Channel getChannelInfo(String channelId) {
        return get("/channels/" + channelId, Channel.class);
    }

    /**
     * 获取子频道列表
     *
     * @param guildId 频道ID
     * @return 子频道对象数组
     */
    public List<Channel> getChannelList(String guildId) {
        JSONArray arr = get("/guilds/" + guildId + "/channels", JSONArray.class);
        return arr.toJavaList(Channel.class);
    }
}
