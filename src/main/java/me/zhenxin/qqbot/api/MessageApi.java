package me.zhenxin.qqbot.api;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息相关接口
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:15
 */
public class MessageApi extends BaseApi {
    public MessageApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
    }

    public void sendTextMessage(String channelId, String content, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("msg_id", messageId);
        String result = post("/channels/" + channelId + "/messages", data);
        System.out.println(result);
    }
}
