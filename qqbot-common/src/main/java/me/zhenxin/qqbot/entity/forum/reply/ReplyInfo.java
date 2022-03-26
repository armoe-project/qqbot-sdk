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

package me.zhenxin.qqbot.entity.forum.reply;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 回复信息
 *
 * @author 真心
 * @since 2022/3/25 19:03
 */
@Data
public class ReplyInfo {
    /**
     * 主题ID
     */
    private String threadId;
    /**
     * 评论ID
     */
    private String postId;
    /**
     * 回复ID
     */
    private String replyId;
    /**
     * 回复内容
     */
    private String content;
    /**
     * 回复时间
     */
    private LocalDateTime dateTime;
}
