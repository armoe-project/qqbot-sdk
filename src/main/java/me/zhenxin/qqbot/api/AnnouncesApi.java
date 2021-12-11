package me.zhenxin.qqbot.api;

import cn.hutool.json.JSONUtil;
import me.zhenxin.qqbot.entity.Announces;

import java.util.HashMap;
import java.util.Map;

/**
 * 公告相关接口
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/11 13:17
 */
public class AnnouncesApi extends BaseApi {
    public AnnouncesApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
    }

    /**
     * 创建子频道公告
     */
    public Announces createAnnounces(String channelId, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("message_id", messageId);
        String result = post("/channels/" + channelId + "/announces", data);
        return JSONUtil.toBean(result, Announces.class);
    }

    /**
     * 删除子频道公告
     */
    public void deleteAnnounces(String channelId, String messageId) {
        delete("/channels/" + channelId + "/announces/" + messageId, null);
    }
}
