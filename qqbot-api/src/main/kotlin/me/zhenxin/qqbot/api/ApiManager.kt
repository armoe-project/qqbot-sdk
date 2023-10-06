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

package me.zhenxin.qqbot.api

import me.zhenxin.qqbot.api.v1.GatewayApi
import me.zhenxin.qqbot.entity.AccessInfo

/**
 * API 管理器
 *
 * @author 真心
 * @since 2023/10/3 20:37
 */
class ApiManager(private val accessInfo: AccessInfo) {

    fun getGatewayApi(): GatewayApi {
        return GatewayApi(accessInfo)
    }
}