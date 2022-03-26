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

package me.zhenxin.qqbot.entity.forum;

import lombok.Data;

/**
 * 帖子审核结果
 *
 * @author 真心
 * @since 2022/3/25 19:05
 */
@Data
public class AuditResult {
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 作者ID
     */
    private String authorId;
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
     * 审核类型
     * <ul>
     *     <li>1: 帖子(PUBLISH_THREAD)</li>
     *     <li>2: 评论(PUBLISH_POST)</li>
     *     <li>3: 回复(PUBLISH_REPLY)</li>
     * </ul>
     */
    private Integer type;
    /**
     * 审核结果. 0:成功 1:失败
     */
    private Integer result;
    /**
     * result不为0时错误信息
     */
    private String errMsg;
}
