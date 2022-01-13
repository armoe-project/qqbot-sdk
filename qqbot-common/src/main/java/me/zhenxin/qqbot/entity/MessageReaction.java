/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
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

/**
 * 表情表态对象
 *
 * @author 真心
 * @since 2021/12/19 12:47
 */
@Data
public class MessageReaction {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 表态对象
     */
    private ReactionTarget target;
    /**
     * 表态所用表情
     */
    private Emoji emoji;
}
