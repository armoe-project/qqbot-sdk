package me.zhenxin.qqbot.template;

import me.zhenxin.qqbot.entity.MessageEmbedThumbnail;
import lombok.Builder;
import me.zhenxin.qqbot.entity.MessageEmbed;
import me.zhenxin.qqbot.entity.MessageEmbedField;

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
