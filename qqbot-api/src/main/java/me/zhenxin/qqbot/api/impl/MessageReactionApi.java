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
import me.zhenxin.qqbot.entity.ReactionUserList;

/**
 * 表情表态API
 *
 * @author 真心
 * @since 2022/5/11 3:04
 */
public class MessageReactionApi extends BaseApi {

    public MessageReactionApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 发送表情表态
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     * @param type      表情表态类型
     * @param id        表情ID 详细列表请参考：<a href="https://bot.q.qq.com/wiki/develop/api/openapi/emoji/model.html">官方文档</a>
     */
    public void sendReaction(String channelId, String messageId, Integer type, String id) {
        put("/channels/" + channelId + "/messages/" + messageId + "/reactions/" + type + "/" + id, null, null);
    }

    /**
     * 删除表情表态
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     * @param type      表情表态类型
     * @param id        表情ID 详细列表请参考：<a href="https://bot.q.qq.com/wiki/develop/api/openapi/emoji/model.html">官方文档</a>
     */
    public void deleteReaction(String channelId, String messageId, Integer type, String id) {
        delete("/channels/" + channelId + "/messages/" + messageId + "/reactions/" + type + "/" + id, null);
    }

    /**
     * 获取表情表态用户列表
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     * @param type      表情表态类型
     * @param id        表情ID 详细列表请参考：<a href="https://bot.q.qq.com/wiki/develop/api/openapi/emoji/model.html">官方文档</a>
     */
    public ReactionUserList getReactionUserList(String channelId, String messageId, Integer type, String id) {
        return get("/channels/" + channelId + "/messages/" + messageId + "/reactions/" + type + "/" + id, ReactionUserList.class);
    }

    /**
     * 获取表情表态用户列表
     *
     * @param channelId 子频道ID
     * @param messageId 消息ID
     * @param type      表情表态类型
     * @param id        表情ID 详细列表请参考：<a href="https://bot.q.qq.com/wiki/develop/api/openapi/emoji/model.html">官方文档</a>
     * @param cookie    上次请求返回的cookie
     * @param limit     每次拉取数量
     */
    public ReactionUserList getReactionUserList(String channelId, String messageId, Integer type, String id, String cookie, Integer limit) {
        return get("/channels/" + channelId + "/messages/" + messageId + "/reactions/" + type + "/" + id + "?cookie=" + cookie + "&limit=" + limit, ReactionUserList.class);
    }

}
