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
 * 机器人 WebSocket 消息载荷
 *
 * @author 真心
 * @since 2023/10/5 22:27
 */
data class Payload(
    /**
     * 操作
     */
    @JSONField(name = "op")
    val op: Int = 0,
    /**
     * 数据
     */
    @JSONField(name = "d")
    val data: Any = Any(),
    /**
     * 序号
     */
    @JSONField(name = "s")
    val seq: Long? = null,
    /**
     * 事件类型
     */
    @JSONField(name = "t")
    val type: String? = null
)
