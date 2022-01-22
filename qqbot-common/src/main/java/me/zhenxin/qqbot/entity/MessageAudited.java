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

import java.time.LocalDateTime;

/**
 * 消息审核对象
 *
 * @author 真心
 * @since 2022/1/22 10:27
 */
@Data
public class MessageAudited {
    /**
     * 消息审核id
     */
    private String auditId;
    /**
     * 消息ID，只有审核通过事件才会有值
     */
    private String messageId;
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 消息审核时间
     */
    private LocalDateTime auditTime;
    /**
     * 消息创建时间
     */
    private LocalDateTime createTime;
}
