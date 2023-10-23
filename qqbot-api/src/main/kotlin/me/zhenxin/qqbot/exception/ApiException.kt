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

package me.zhenxin.qqbot.exception

/**
 * API 请求异常
 *
 * @author 真心
 * @since 2023/10/5 20:30
 */
class ApiException(
    /**
     * 错误码
     */
    val code: Int,
    /**
     * 错误详情
     */
    val detail: String,
    /**
     * 错误 ID
     */
    val traceId: String,
    /**
     * 错误信息
     */
    override val message: String = "Status Code: $code, Detail: $detail, TraceId: $traceId"
) : RuntimeException(message)