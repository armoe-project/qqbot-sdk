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

/**
 * 身份组对象
 *
 * @author 真心
 * @since 2021/12/11 21:35
 */
@Data
public class Role {
    /**
     * 身份组ID
     * <pre>
     * 1 - 全体成员
     * 2 - 管理员
     * 4 - 创建者
     * 5 - 子频道管理员
     * 其他 - 用户创建的身份组ID
     * </pre>
     */
    private String id;
    /**
     * 身份组名称
     */
    private String name;
    /**
     * 身份组颜色
     */
    private Long color;
    /**
     * 是否在成员列表中显示
     */
    private Integer hoist;
    /**
     * 人数
     */
    private Integer number;
    /**
     * 成员上限
     */
    private Integer memberLimit;
}
