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
 * 子频道发言权限
 *
 * @author 真心
 * @since 2023/10/23 10:41
 */
enum class SpeakPermission(val value: Int) {
    /**
     * 无效类型
     */
    INVALID(0),

    /**
     * 所有人
     */
    ALL(1),

    /**
     * 群主/管理员/指定用户
     */
    CUSTOM(2),
}