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
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.DirectMessageSession;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.MessageEmbed;
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.exception.ApiException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 私信相关接口
 *
 * @author 真心
 * @since 2022/1/22 11:11
 */
public class DirectMessageApi extends BaseApi {
    public DirectMessageApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 创建私信会话
     *
     * @param recipientId 接收者ID
     * @param guildId     源频道ID
     * @return {@link DirectMessageSession} 对象
     */
    public DirectMessageSession createSession(String recipientId, String guildId) {
        Map<String, Object> data = new HashMap<>();
        data.put("recipient_id", recipientId);
        data.put("source_guild_id", guildId);
        return post("/users/@me/dms", data, DirectMessageSession.class);
    }

    /**
     * 发送文本消息
     *
     * @param guildId   频道ID
     * @param content   文本内容
     * @param messageId 消息ID
     * @return {@link Message} 对象
     */
    public Message sendMessage(String guildId, String content, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("msg_id", messageId);
        return sendMessage(guildId, data);
    }

    /**
     * 发送图片消息
     *
     * @param guildId   频道ID
     * @param image     图片URL
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String guildId, URL image, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("image", image.toString());
        data.put("msg_id", messageId);
        return sendMessage(guildId, data);
    }

    /**
     * 发送文本和图片消息
     *
     * @param guildId   频道ID
     * @param content   文本内容
     * @param image     图片URL
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String guildId, String content, URL image, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("content", content);
        data.put("image", image.toString());
        data.put("msg_id", messageId);
        return sendMessage(guildId, data);
    }

    /**
     * 发送模板(Ark)消息
     *
     * @param guildId   频道ID
     * @param ark       MessageArk对象
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String guildId, MessageArk ark, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("ark", ark);
        data.put("msg_id", messageId);
        return sendMessage(guildId, data);
    }

    /**
     * 发送 Embed 消息
     *
     * @param guildId   频道ID
     * @param embed     Embed 消息
     * @param messageId 消息ID
     * @return 消息对象
     */
    public Message sendMessage(String guildId, MessageEmbed embed, String messageId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        data.put("embed", embed);
        data.put("msg_id", messageId);
        return sendMessage(guildId, data);
    }

    private Message sendMessage(String guildId, Map<String, Object> data) {
        return post("/dms/" + guildId + "/messages", data, Message.class);
    }
}
