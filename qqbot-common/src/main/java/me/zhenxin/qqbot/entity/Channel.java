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
 * 子频道对象
 *
 * @author 真心
 * @since 2021/12/11 12:53
 */
@Data
public class Channel {
    /**
     * 子频道ID
     */
    private String id;
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道名称
     */
    private String name;
    /**
     * 子频道类型
     */
    private Integer type;
    /**
     * 子频道子类型
     */
    private Integer subType;
    /**
     * 排序 (必填，而且不能够和其他子频道的值重复)
     */
    private Integer position;
    /**
     * 分组ID
     */
    private String parentId;
    /**
     * 创建人ID
     */
    private String ownerId;
}
