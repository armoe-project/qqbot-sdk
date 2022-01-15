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
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.entity.ark.MessageArkKv;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本+缩略图模板
 *
 * @author 真心
 * @since 2021/12/9 17:08
 */
@Builder
public class TextThumbnailTemplate {
    /**
     * 描述
     */
    private String desc;
    /**
     * 提示文本
     */
    private String prompt;
    /**
     * 标题
     */
    private String title;
    /**
     * 详细描述
     */
    private String metaDesc;
    /**
     * 图片链接
     */
    private String img;
    /**
     * 跳转链接
     */
    private String link;
    /**
     * 来源
     */
    private String subTitle;

    public MessageArk toMessageArk() {
        MessageArk ark = new MessageArk();
        ark.setTemplateId(24);
        List<MessageArkKv> arkKv = new ArrayList<>();
        MessageArkKv desc = new MessageArkKv();
        desc.setKey("#DESC#");
        desc.setValue(this.desc);
        MessageArkKv prompt = new MessageArkKv();
        prompt.setKey("#PROMPT#");
        prompt.setValue(this.prompt);
        MessageArkKv title = new MessageArkKv();
        title.setKey("#TITLE#");
        title.setValue(this.title);
        MessageArkKv meteDesc = new MessageArkKv();
        meteDesc.setKey("#METADESC#");
        meteDesc.setValue(this.metaDesc);
        MessageArkKv img = new MessageArkKv();
        img.setKey("#IMG#");
        img.setValue(this.img);
        MessageArkKv link = new MessageArkKv();
        link.setKey("#LINK#");
        link.setValue(this.link);
        MessageArkKv subTitle = new MessageArkKv();
        subTitle.setKey("#SUBTITLE#");
        subTitle.setValue(this.subTitle);
        arkKv.add(desc);
        arkKv.add(prompt);
        arkKv.add(title);
        arkKv.add(meteDesc);
        arkKv.add(img);
        arkKv.add(link);
        arkKv.add(subTitle);
        ark.setKv(arkKv);
        return ark;
    }
}
