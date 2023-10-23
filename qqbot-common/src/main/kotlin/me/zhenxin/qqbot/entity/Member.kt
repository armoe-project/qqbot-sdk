/*
 * QQBot SDK - QQ Official Bot SDK
 * Copyright (C) 2023 ZhenXin
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

package me.zhenxin.qqbot.entity

import com.alibaba.fastjson2.annotation.JSONField

/**
 * 成员
 *
 * @author 真心
 * @since 2023/10/23 14:10
 */
data class Member(
    /**
     * 频道 ID
     */
    @JSONField(name = "guild_id")
    val guildId: String = "",
    /**
     * 用户
     */
    var user: User = User(),
    /**
     * 昵称
     */
    @JSONField(name = "nick")
    var nickname: String = "",
    /**
     * 身份组
     */
    var roles: List<String> = emptyList(),
    /**
     * 加入时间
     */
    @JSONField(name = "joined_at")
    var joinedAt: String = "",
)
