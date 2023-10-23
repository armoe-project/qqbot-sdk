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

package me.zhenxin.qqbot.enums

/**
 * 子频道子类型
 *
 * @author 真心
 * @since 2023/10/23 10:33
 */
enum class ChannelSubType(val value: Int) {
    /**
     * 闲聊
     */
    CHAT(0),

    /**
     * 公告
     */
    ANNOUNCEMENT(1),

    /**
     * 攻略
     */
    GUIDE(2),

    /**
     * 开黑
     */
    TEAM(3),
}