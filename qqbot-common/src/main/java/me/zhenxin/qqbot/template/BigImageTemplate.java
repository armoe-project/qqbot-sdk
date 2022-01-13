/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
 * Copyright (C) 2022 xiaoye-bot Project Team
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
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.entity.ark.MessageArkKv;

import java.util.ArrayList;
import java.util.List;

/**
 * 大图模板
 *
 * @author 真心
 * @since 2021/12/9 17:09
 */
@Builder
public class BigImageTemplate {
    /**
     * 提示文本
     */
    private String prompt;
    /**
     * 标题
     */
    private String metaTitle;
    /**
     * 子标题
     */
    private String metaSubTitle;
    /**
     * 大图，尺寸为 975*540
     */
    private String metaCover;
    /**
     * 跳转链接
     */
    private String metaUrl;

    public MessageArk toMessageArk() {
        MessageArk ark = new MessageArk();
        ark.setTemplateId(37);
        List<MessageArkKv> arkKv = new ArrayList<>();
        MessageArkKv prompt = new MessageArkKv();
        prompt.setKey("#PROMPT#");
        prompt.setValue(this.prompt);
        MessageArkKv metaTitle = new MessageArkKv();
        metaTitle.setKey("#METATITLE#");
        metaTitle.setValue(this.metaTitle);
        MessageArkKv metaSubTitle = new MessageArkKv();
        metaSubTitle.setKey("#METASUBTITLE#");
        metaSubTitle.setValue(this.metaSubTitle);
        MessageArkKv metaCover = new MessageArkKv();
        metaCover.setKey("#METACOVER#");
        metaCover.setValue(this.metaCover);
        MessageArkKv metaUrl = new MessageArkKv();
        metaUrl.setKey("#METAURL#");
        metaUrl.setValue(this.metaUrl);
        arkKv.add(prompt);
        arkKv.add(metaTitle);
        arkKv.add(metaSubTitle);
        arkKv.add(metaCover);
        arkKv.add(metaCover);
        ark.setKv(arkKv);
        return ark;
    }
}
