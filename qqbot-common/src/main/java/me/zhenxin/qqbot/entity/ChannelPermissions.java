/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
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

package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 子频道权限
 *
 * @author 真心
 * @since 2021/12/24 10:25
 */
@Data
public class ChannelPermissions {
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户拥有的子频道权限权限
     * <br/>
     * <a href="https://bot.q.qq.com/wiki/develop/api/openapi/channel_permissions/model.html#permissions">权限列表</a>
     */
    private String permissions;
}
