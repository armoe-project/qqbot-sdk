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
 * WebSocket 鉴权信息
 *
 * @author 真心
 * @since 2023/10/6 0:31
 */
data class Identify(
    /**
     * Token
     */
    @JSONField(name = "token")
    var token: String,
    /**
     * 订阅事件
     */
    @JSONField(name = "intents")
    var intents: Int,
    /**
     * 分片数量
     */
    @JSONField(name = "shard")
    val shard: List<Int> = listOf(0, 1),
    /**
     * 配置信息
     */
    @JSONField(name = "properties")
    val properties: Map<String, String> = mapOf()
)
