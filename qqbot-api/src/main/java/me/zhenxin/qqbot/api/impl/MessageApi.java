package me.zhenxin.qqbot.api.impl;

import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.MessageEmbed;
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.exception.ApiException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息相关接口
 *
 * @author 真心
 * @since 2021/12/8 16:15
 */
@SuppressWarnings("UnusedReturnValue")
public class MessageApi extends BaseApi {
    public MessageApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 发送文本消息
     *
     * @param channelId 子频道ID
     * @param content   文本内容
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String channelId, String content, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    /**
     * 发送图片消息
     *
     * @param channelId 子频道ID
     * @param image     图片URL
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String channelId, URL image, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("image", image.toString());
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    /**
     * 发送文本和图片消息
     *
     * @param channelId 子频道ID
     * @param content   文本内容
     * @param image     图片URL
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String channelId, String content, URL image, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("image", image.toString());
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    /**
     * 发送模板(Ark)消息
     *
     * @param channelId 子频道ID
     * @param ark       MessageArk对象
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String channelId, MessageArk ark, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("ark", ark);
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    /**
     * 发送 Embed 消息
     *
     * @param channelId 子频道ID
     * @param embed     Embed 消息
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String channelId, MessageEmbed embed, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("embed", embed);
        data.put("msg_id", messageId);
        return getResult(channelId, data);
    }

    /**
     * 撤回消息
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     */
    public void deleteMessage(String channelId, String messageId) throws ApiException {
        delete("/channels/" + channelId + "/messages/" + messageId, null);
    }

    /**
     * 发送文本消息
     *
     * @param channelId 子频道ID
     * @param content   文本内容
     * @param messageId 消息ID
     * @return 消息对象
     * @deprecated 使用 {@link #sendMessage(String, String, String)} 替代
     */
    public Message sendTextMessage(String channelId, String content, String messageId) throws ApiException {
        return sendMessage(channelId, content, messageId);
    }

    /**
     * 发送模板(Ark)消息
     *
     * @param channelId 子频道ID
     * @param ark       MessageArk对象
     * @param messageId 消息ID
     * @return 消息对象
     * @deprecated 使用 {@link #sendMessage(String, MessageArk, String)} 替代
     */
    public Message sendTemplateMessage(String channelId, MessageArk ark, String messageId) throws ApiException {
        return sendMessage(channelId, ark, messageId);
    }

    /**
     * 发送图片消息
     *
     * @param channelId 子频道ID
     * @param image     图片URL
     * @param messageId 消息ID
     * @return 消息对象
     * @deprecated 使用 {@link #sendMessage(String, URL, String)} 替代
     */
    public Message sendImageMessage(String channelId, String image, String messageId) throws ApiException {
        try {
            return sendMessage(channelId, new URL(image), messageId);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 发送文本和图片消息
     *
     * @param channelId 子频道ID
     * @param content   文本内容
     * @param image     图片URL
     * @param messageId 消息ID
     * @return 消息对象
     * @deprecated 使用 {@link #sendMessage(String, String, URL, String)} 替代
     */
    public Message sendTextAndImageMessage(String channelId, String content, String image, String messageId) throws ApiException {
        try {
            return sendMessage(channelId, content, new URL(image), messageId);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取指定消息
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message getMessageInfo(String channelId, String messageId) {
        return get("/channels/" + channelId + "/messages/" + messageId, Message.class);
    }


    private Message getResult(String channelId, Map<String, Object> data) {
        return post("/channels/" + channelId + "/messages", data, Message.class);
    }
}
