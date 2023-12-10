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

package me.zhenxin.qqbot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Intents
 *
 * @author 真心
 * @since 2021/12/9 0:37
 */
@SuppressWarnings("PointlessBitwiseExpression")
@Getter
@AllArgsConstructor
public enum Intent {
    /**
     * 频道相关事件
     */
    GUILDS(1 << 0),
    /**
     * 频道成员相关事件
     */
    GUILD_MEMBERS(1 << 1),
    /**
     * 用户消息事件(私域可用)
     *
     * @deprecated 请使用 {@link #GUILD_MESSAGES}
     */
    @Deprecated
    USER_MESSAGES(1 << 9),
    /**
     * 私域频道消息事件
     */
    GUILD_MESSAGES(1 << 9),
    /**
     * 消息表态相关事件
     */
    GUILD_MESSAGE_REACTIONS(1 << 10),
    /**
     * 私聊消息相关事件
     */
    DIRECT_MESSAGE(1 << 12),
    /**
     * 群聊消息相关事件
     */
    GROUP_MESSAGE(1 << 25),
    /**
     * 互动相关事件
     */
    INTERACTION(1 << 26),
    /**
     * 消息审核相关事件
     */
    MESSAGE_AUDIT(1 << 27),
    /**
     * 论坛相关事件 (私域可用)
     */
    FORUM_EVENT(1 << 28),
    /**
     * 音频相关事件
     */
    AUDIO_ACTION(1 << 29),
    /**
     * 艾特消息事件
     *
     * @deprecated 请使用 {@link #PUBLIC_GUILD_MESSAGES}
     */
    @Deprecated
    AT_MESSAGES(1 << 30),
    /**
     * 公域频道消息事件
     */
    PUBLIC_GUILD_MESSAGES(1 << 30);

    private final Integer value;
}
