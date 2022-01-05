package me.zhenxin.qqbot.api.impl;

import com.alibaba.fastjson.JSONArray;
import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.Channel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 创建子频道 (仅私域可用)
     *
     * @param guildId  频道ID
     * @param name     子频道名称
     * @param type     子频道类型 (<a href="https://bot.q.qq.com/wiki/develop/api/openapi/channel/model.html#channeltype">官方文档</a>)
     * @param position 子频道排序
     * @param parentId 分组ID
     * @return 子频道对象
     */
    public Channel createChannel(String guildId, String name, String type, int position, String parentId) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("type", type);
        data.put("position", position);
        data.put("parent_id", parentId);
        return post("/guilds/" + guildId + "/channels", data, Channel.class);
    }

    /**
     * 修改子频道 (仅私域可用)
     *
     * @param channelId 子频道ID
     * @param name      子频道名称
     * @param type      子频道类型 (<a href="https://bot.q.qq.com/wiki/develop/api/openapi/channel/model.html#channeltype">官方文档</a>)
     * @param position  子频道排序
     * @param parentId  分组ID
     * @return 子频道对象
     */
    public Channel changeChannel(String channelId, String name, String type, int position, String parentId) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("type", type);
        data.put("position", position);
        data.put("parent_id", parentId);
        return patch("/channels/" + channelId, data, Channel.class);
    }

    /**
     * 删除子频道 (仅私域可用)
     *
     * @param channelId 子频道ID
     */
    public void deleteChannel(String channelId) {
        delete("/channels/" + channelId, null);
    }
}
