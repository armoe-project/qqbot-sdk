/*
 * qq-official-bot-sdk - QQ Official Bot SDK For Java
 * Copyright (C) 2021-2022 xiaoye-bot Project Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.zhenxin.qqbot.api.impl;

import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.*;
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.exception.ApiException;

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
     * @return {@link Message} 对象
     */
    public Message sendMessage(String channelId, String content, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("msg_id", messageId);
        return sendMessage(channelId, data);
    }

    /**
     * 发送图片消息
     *
     * @param channelId 子频道ID
     * @param image     图片URL
     * @param messageId 消息ID
     * @return {@link Message} 对象
     */
    public Message sendMessage(String channelId, URL image, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("image", image.toString());
        data.put("msg_id", messageId);
        return sendMessage(channelId, data);
    }

    /**
     * 发送文本和图片消息
     *
     * @param channelId 子频道ID
     * @param content   文本内容
     * @param image     图片URL
     * @param messageId 消息ID
     * @return {@link Message} 对象
     */
    public Message sendMessage(String channelId, String content, URL image, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("image", image.toString());
        data.put("msg_id", messageId);
        return sendMessage(channelId, data);
    }

    /**
     * 发送模板(Ark)消息
     *
     * @param channelId 子频道ID
     * @param ark       {@link MessageArk} 对象
     * @param messageId 消息ID
     * @return {@link Message} 对象
     */
    public Message sendMessage(String channelId, MessageArk ark, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("ark", ark);
        data.put("msg_id", messageId);
        return sendMessage(channelId, data);
    }

    /**
     * 发送 Embed 消息
     *
     * @param channelId 子频道ID
     * @param embed     {@link MessageEmbed} 对象
     * @param messageId 消息ID
     * @return {@link Message} 对象
     */
    public Message sendMessage(String channelId, MessageEmbed embed, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("embed", embed);
        data.put("msg_id", messageId);
        return sendMessage(channelId, data);
    }

    /**
     * 发送Markdown消息
     *
     * @param channelId 子频道ID
     * @param markdown  {@link MessageMarkdown} 对象
     * @param messageId 消息ID
     * @return {@link Message} 对象
     */
    public Message sendMessage(String channelId, MessageMarkdown markdown, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("markdown", markdown);
        data.put("msg_id", messageId);
        return sendMessage(channelId, data);
    }

    /**
     * 发送按钮消息
     *
     * @param channelId 子频道ID
     * @param markdown  {@link MessageMarkdown} 对象
     * @param keyboard  {@link MessageKeyboard} 对象
     * @param messageId 消息ID
     * @return {@link Message} 对象
     */
    public Message sendMessage(String channelId, MessageMarkdown markdown, MessageKeyboard keyboard, String messageId) {
        Map<String, Object> data = new HashMap<>();
        data.put("markdown", markdown);
        data.put("keyboard", keyboard);
        data.put("msg_id", messageId);
        return sendMessage(channelId, data);
    }

    /**
     * 撤回消息 (仅私域可用)
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     */
    public void deleteMessage(String channelId, String messageId) throws ApiException {
        delete("/channels/" + channelId + "/messages/" + messageId, null);
    }

    /**
     * 获取指定消息
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     * @return {@link Message} 对象
     */
    public Message getMessageInfo(String channelId, String messageId) {
        return get("/channels/" + channelId + "/messages/" + messageId, Message.class);
    }

    /**
     * 获取频道消息频率设置
     *
     * @param guildId 频道ID
     * @return @{@link MessageSetting} 对象
     */
    public MessageSetting getMessageSetting(String guildId) {
        return get("/guilds/" + guildId + "/message/setting", MessageSetting.class);
    }


    /**
     * 发送消息
     *
     * @param channelId 子频道ID
     * @param data      消息数据
     * @return {@link Message} 对象
     */
    private Message sendMessage(String channelId, Map<String, Object> data) {
        return post("/channels/" + channelId + "/messages", data, Message.class);
    }
}
