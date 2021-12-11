package me.zhenxin.qqbot.template;

import lombok.Builder;
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.entity.ark.MessageArkKv;
import me.zhenxin.qqbot.entity.ark.MessageArkObj;
import me.zhenxin.qqbot.entity.ark.MessageArkObjKv;

import java.util.ArrayList;
import java.util.List;

/**
 * 链接+文本列表模板
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 17:07
 */
@Builder
public class LinkTextTemplate {
    /**
     * 描述
     */
    private String desc;
    /**
     * 提示消息
     */
    private String prompt;
    /**
     * #LIST# 数组
     */
    private List<LinkText> list;

    public MessageArk toMessageArk() {
        MessageArk ark = new MessageArk();
        ark.setTemplateId(23);

        MessageArkKv desc = new MessageArkKv();
        desc.setKey("#DESC#");
        desc.setValue(this.desc);
        List<MessageArkKv> arkKv = new ArrayList<>();
        MessageArkKv prompt = new MessageArkKv();
        prompt.setKey("#PROMPT#");
        prompt.setValue(this.prompt);
        MessageArkKv list = new MessageArkKv();
        List<MessageArkObj> arkObjs = new ArrayList<>();
        for (LinkText it : this.list) {
            MessageArkObj arkObj = new MessageArkObj();
            List<MessageArkObjKv> arkObjKv = new ArrayList<>();
            MessageArkObjKv descObj = new MessageArkObjKv();
            descObj.setKey("desc");
            descObj.setValue(it.getDesc());
            MessageArkObjKv linkObj = new MessageArkObjKv();
            linkObj.setKey("link");
            linkObj.setValue(it.getLink());
            arkObjKv.add(descObj);
            arkObjKv.add(linkObj);
            arkObj.setObjKv(arkObjKv);
            arkObjs.add(arkObj);
        }

        list.setKey("#LIST#");
        list.setObj(arkObjs);
        arkKv.add(desc);
        arkKv.add(prompt);
        arkKv.add(list);
        ark.setKv(arkKv);
        return ark;
    }
}
