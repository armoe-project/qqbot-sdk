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

import java.util.List;

/**
 * Markdown消息对象
 *
 * @author 真心
 * @since 2022/5/11 2:35
 */
@Data
public class MessageMarkdown {
    /**
     * 模板ID
     */
    private String templateId;
    /**
     * 自定义模板ID
     */
    private String customTemplateId;
    /**
     * 模板参数
     */
    private List<MessageMarkdownParams> params;
    /**
     * 消息内容
     */
    private String content;
}
