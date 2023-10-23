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
 * 准备就绪
 *
 * @author 真心
 * @since 2023/10/23 10:57
 */
data class Ready(
    /**
     * 版本
     */
    val version: String,
    /**
     * 会话 ID
     */
    @JSONField(name = "session_id")
    val sessionId: String,
    /**
     * 用户
     */
    val user: User,
    /**
     * 分片数据
     */
    val shard: List<Int>,
)
