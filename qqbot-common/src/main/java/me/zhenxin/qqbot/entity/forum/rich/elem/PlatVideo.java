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
 * 平台视频
 *
 * @author 真心
 * @since 2022/3/26 20:07
 */
@Data
public class PlatVideo {
    /**
     * 链接
     */
    private String url;
    /**
     * 图片宽度
     */
    private Integer width;
    /**
     * 图片高度
     */
    private Integer height;
    /**
     * 视频ID
     */
    private String videoId;
    /**
     * 视频封面
     */
    private PlatImage cover;

}
