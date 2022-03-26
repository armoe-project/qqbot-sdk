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

package me.zhenxin.qqbot.entity.forum.rich.elem;

import lombok.Data;

/**
 * 元素列表结构
 *
 * @author 真心
 * @since 2022/3/26 19:55
 */
@Data
public class Elem {
    /**
     * 文本元素
     */
    private TextElem text;
    /**
     * 图片元素
     */
    private ImageElem image;
    /**
     * 视频元素
     */
    private VideoElem video;
    /**
     * 链接元素
     */
    private UrlElem url;
    /**
     * 元素类型
     * <ul>
     *     <li>1: 文本</li>
     *     <li>2: 图片</li>
     *     <li>3: 视频</li>
     *     <li>4: 链接</li>
     * </ul>
     */
    private Integer type;
}
