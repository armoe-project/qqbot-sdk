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

package me.zhenxin.qqbot.entity;

import lombok.Data;
import me.zhenxin.qqbot.entity.Role;

import java.util.List;

/**
 * 身份组列表
 *
 * @author 真心
 * @since 2021/12/11 11:04
 */
@Data
public class RoleList {
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 身份组列表
     */
    private List<Role> roles;
    /**
     * 默认分组上限
     */
    private Integer roleNumLimit;
}
