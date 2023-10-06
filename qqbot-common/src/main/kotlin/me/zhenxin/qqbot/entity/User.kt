/*
 * QQBot SDK - QQ Official Bot SDK For Java
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
 * 用户
 *
 * @author 真心
 * @since 2023/10/6 17:06
 */
data class User(
    /**
     * 用户 ID
     */
    var id: Long = 0,
    /**
     * 用户名
     */
    var username: String = "",
    /**
     * 用户的头像地址
     */
    var avatar: String = "",
    /**
     * 是否是机器人
     */
    var bot: Boolean = false,
    /**
     * UnionOpenId
     */
    @JSONField(name = "union_openid")
    var unionOpenId: String = "",
    /**
     * UnionUserAccount
     */
    var unionUserAccount: String = "",
)
