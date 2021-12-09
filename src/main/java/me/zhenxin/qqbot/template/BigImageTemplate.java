package me.zhenxin.qqbot.template;

import lombok.Builder;
import me.zhenxin.qqbot.pojo.ark.MessageArk;
import me.zhenxin.qqbot.pojo.ark.MessageArkKv;

import java.util.ArrayList;
import java.util.List;

/**
 * 大图模板
 *
 * @author 真心
 * @email qgzhenxin@qq.com
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
