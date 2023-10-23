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

/**
 * 访问信息
 *
 * @author 真心
 * @since 2023/10/1 23:55
 */
data class AccessInfo(
    /**
     * 管理端的 BotAppID
     */
    var botAppId: Int = 0,
    /**
     * 管理端的 机器人令牌
     */
    var botToken: String = "",
    /**
     * 管理端的 机器人密钥
     */
    var botSecret: String = "",
    /**
     * 是否使用沙箱环境
     */
    var isSandbox: Boolean = false
)