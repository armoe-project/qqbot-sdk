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

package me.zhenxin.qqbot.entity.forum.rich.info;

import lombok.Data;

/**
 * 艾特信息
 *
 * @author 真心
 * @since 2022/3/25 19:22
 */
@Data
public class AtInfo {
    /**
     * 艾特类型
     * <ul>
     *     <li>1: 指定人</li>
     *     <li>2: 指定身份组</li>
     *     <li>3: 全体成员</li>
     * </ul>
     */
    private Integer type;
    /**
     * 用户
     */
    private AtUserInfo userInfo;
    /**
     * 身份组
     */
    private AtRoleInfo roleInfo;
    /**
     * 全体成员
     */
    private AtGuildInfo guildInfo;
}
