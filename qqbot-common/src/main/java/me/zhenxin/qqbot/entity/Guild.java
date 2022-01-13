/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
 * Copyright (C) 2022 xiaoye-bot Project Team
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
 * 频道对象
 *
 * @author 真心
 * @since 2021/12/8 15:44
 */
@Data
public class Guild {
    /**
     * 频道ID
     */
    private String id;
    /**
     * 频道名称
     */
    private String name;
    /**
     * 频道头像地址
     */
    private String icon;
    /**
     * 创建人用户ID
     */
    private String ownerId;
    /**
     * 当前人是否是创建人
     */
    private Boolean owner;
    /**
     * 操作用户ID
     */
    private String opUserId;
    /**
     * 成员数
     */
    private Integer memberCount;
    /**
     * 最大成员数
     */
    private Integer maxMembers;
    /**
     * 简介
     */
    private String description;
    /**
     * 加入时间
     */
    private Long joinedAt;
}
