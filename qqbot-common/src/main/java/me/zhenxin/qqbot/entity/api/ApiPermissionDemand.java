/*
 * qq-official-bot-sdk - QQ Official Bot SDK For Java
 * Copyright (C) 2021-2022 xiaoye-bot Project Team
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

package me.zhenxin.qqbot.entity.api;

import lombok.Data;

/**
 * 接口权限需求对象
 *
 * @author 真心
 * @since 2022/2/6 14:46
 */
@Data
public class ApiPermissionDemand {
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 接口权限需求标识
     */
    private ApiPermissionDemandIdentify apiIdentify;
    /**
     * 接口权限描述信息
     */
    private String title;
    /**
     * 可使用功能的描述信息
     */
    private String desc;
}
