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

package me.zhenxin.qqbot.entity.forum.rich;

import lombok.Data;

/**
 * 段落属性
 *
 * @author 真心
 * @since 2022/3/26 20:09
 */
@Data
public class ParagraphProps {
    /**
     * 段落对齐方向属性
     * <ul>
     *     <li>0: 居左</li>
     *     <li>1: 居中</li>
     *     <li>2: 居右</li>
     * </ul>
     */
    private Integer alignment;
}
