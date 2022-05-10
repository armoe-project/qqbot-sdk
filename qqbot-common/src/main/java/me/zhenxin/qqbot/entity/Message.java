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

package me.zhenxin.qqbot.entity;

import lombok.Data;
import me.zhenxin.qqbot.entity.ark.MessageArk;

import java.time.LocalDateTime;

/**
 * 消息对象
 *
 * @author 真心
 * @since 2021/12/8 16:16
 */
@Data
public class Message {
    /**
     * 消息ID
     */
    private String id;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息创建时间
     */
    private LocalDateTime timestamp;
    /**
     * 消息编辑时间
     */
    private LocalDateTime editedTimestamp;
    /**
     * 是否为 @全体成员 消息
     */
    private Boolean mentionEveryone;
    /**
     * 消息创建人
     */
    private User author;
    /**
     * 消息附件
     */
    private MessageAttachment[] attachments;
    /**
     * Embed
     */
    private MessageEmbed[] embeds;
    /**
     * 消息中@的人
     */
    private User[] mentions;
    /**
     * 消息创建者的信息
     */
    private Member member;
    /**
     * Ark消息
     */
    private MessageArk ark;
    /**
     * 消息序号
     * <p>
     * 子频道消息的序号，用于消息间的排序。<br/>
     * 在同一子频道中按从先到后的顺序递增。<br/>
     * 不同的子频道之间消息无法排序。
     * </p>
     */
    private String seqInChannel;
    /**
     * 引用消息
     */
    private MessageReference messageReference;
    /**
     * 来源频道ID
     * <p>
     * 用于私信场景下识别真实的来源频道。
     * </p>
     */
    private String srcGuildId;
}
