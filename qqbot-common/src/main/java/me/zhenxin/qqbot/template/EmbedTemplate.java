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

package me.zhenxin.qqbot.template;

import lombok.Builder;
import me.zhenxin.qqbot.entity.MessageEmbed;
import me.zhenxin.qqbot.entity.MessageEmbedField;
import me.zhenxin.qqbot.entity.MessageEmbedThumbnail;

import java.util.ArrayList;
import java.util.List;

/**
 * Embed 模板
 *
 * @author 真心
 * @since 2021/12/24 11:04
 */
@Builder
public class EmbedTemplate {
    private String title;
    private String prompt;
    private String thumbnail;
    private List<String> fields;

    public MessageEmbed toMessageEmbed() {
        MessageEmbed embed = new MessageEmbed();
        embed.setTitle(title);
        embed.setPrompt(prompt);
        MessageEmbedThumbnail th = new MessageEmbedThumbnail();
        th.setUrl(thumbnail);
        embed.setThumbnail(th);
        List<MessageEmbedField> embedFields = new ArrayList<>();
        if (fields == null) fields = new ArrayList<>();
        for (String name : fields) {
            MessageEmbedField field = new MessageEmbedField();
            field.setName(name);
            embedFields.add(field);
        }
        embed.setFields(embedFields);
        return embed;
    }
}
