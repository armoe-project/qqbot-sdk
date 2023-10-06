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

/**
 * 网关
 *
 * @author 真心
 * @since 2023/10/3 21:03
 */
data class Gateway(
    /**
     * WebSocket 的连接地址
     */
    var url: String = "",
    /**
     * 建议 Shard 数量
     */
    var shards: Int = 1,
    /**
     * Session 限制信息
     */
    var sessionStartLimit: SessionStartLimit = SessionStartLimit(),
)

/**
 * Session 限制信息
 */
data class SessionStartLimit(
    /**
     * 总数
     */
    var total: Int = 0,
    /**
     * 剩余
     */
    var remaining: Int = 0,
    /**
     * 重置时间
     */
    var resetAfter: Int = 0,
    /**
     * 最大并发数
     */
    var maxConcurrency: Int = 0,
)
