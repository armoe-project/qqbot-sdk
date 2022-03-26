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
import me.zhenxin.qqbot.entity.forum.rich.info.TextInfo;

/**
 * 富文本对象
 *
 * @author 真心
 * @since 2022/3/25 19:17
 */
@Data
public class RichObject {
    /**
     * 富文本类型
     * <ul>
     *     <li>1: 普通文本</li>
     *     <li>2: AT信息</li>
     *     <li>3: URL信息</li>
     *     <li>4: 表情信息</li>
     *     <li>5: #子频道</li>
     *     <li>10: 视频</li>
     *     <li>11: 图片</li>
     * </ul>
     */
    private Integer type;
    /**
     * 文本
     */
    private TextInfo textInfo;
}
