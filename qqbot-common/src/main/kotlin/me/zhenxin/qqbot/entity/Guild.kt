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
 * 频道
 *
 * @author 真心
 * @since 2023/10/23 10:00
 */
data class Guild(
    /**
     * 频道 ID
     */
    var id: Long = 0,
    /**
     * 频道名称
     */
    var name: String = "",
    /**
     * 频道头像地址
     */
    var icon: String = "",
    /**
     * 创建人用户 ID
     */
    @JSONField(name = "owner_id")
    var ownerId: Long = 0,
    /**
     * 当前是否为创建人
     */
    @JSONField(name = "owner")
    var isOwner: Boolean = false,
    /**
     * 成员数量
     */
    @JSONField(name = "member_count")
    var memberCount: Int = 0,
    /**
     * 最大成员数量
     */
    @JSONField(name = "max_members")
    var maxMembers: Int = 0,
    /**
     * 描述
     */
    var description: String = "",
    /**
     * 加入时间
     */
    @JSONField(name = "joined_at")
    var joinedAt: String = "",
    /**
     * 操作用户 ID (仅在事件中存在)
     */
    @JSONField(name = "op_user_id")
    var opUserId: Long = 0,
)