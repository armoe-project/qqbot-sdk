package me.zhenxin.qqbot.api.impl;

import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.Announces;
import me.zhenxin.qqbot.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

/**
 * 公告相关接口
 *
 * @author 真心
 * @since 2021/12/11 13:17
 */
public class AnnouncesApi extends BaseApi {
    public AnnouncesApi(AccessInfo accessInfo) {
        super(accessInfo);
    }


    /**
     * 创建频道全局公告
     *
     * @param guildId   频道ID
     * @param channelId 子频道ID
     * @param messageId 消息ID
     */
    public Announces createGuildAnnounces(String guildId, String channelId, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("message_id", messageId);
        data.put("channel_id", channelId);
        return post("/guilds/" + guildId + "/announces", data, Announces.class);
    }

    /**
     * 删除频道全局公告
     *
     * @param guildId   频道ID
     * @param messageId 消息ID
     */
    public void deleteGuildAnnounces(String guildId, String messageId) throws ApiException {
        delete("/guilds/" + guildId + "/announces/" + messageId, null);
    }

    /**
     * 创建子频道公告
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     */
    public Announces createAnnounces(String channelId, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("message_id", messageId);
        return post("/channels/" + channelId + "/announces", data, Announces.class);
    }

    /**
     * 删除子频道公告
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     */
    public void deleteAnnounces(String channelId, String messageId) throws ApiException {
        delete("/channels/" + channelId + "/announces/" + messageId, null);
    }
}
