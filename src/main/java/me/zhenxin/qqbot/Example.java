package me.zhenxin.qqbot;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.core.AccessInfo;
import me.zhenxin.qqbot.core.ApiManager;
import me.zhenxin.qqbot.core.BotCore;
import me.zhenxin.qqbot.core.EventHandler;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.pojo.Message;
import me.zhenxin.qqbot.pojo.ark.MessageArk;
import me.zhenxin.qqbot.template.LinkText;
import me.zhenxin.qqbot.template.LinkTextTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例程序
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 15:41
 */
@Slf4j
class Example {
    public static void main(String[] args) {
        AccessInfo accessInfo = new AccessInfo();
        accessInfo.setBotAppId(Integer.parseInt(System.getenv("BotAppid")));
        accessInfo.setBotToken(System.getenv("BotToken"));
        BotCore bot = new BotCore(accessInfo);
        ApiManager api = bot.getApiManager();
        bot.registerAtMessageEvent();
        bot.setEventHandler(new IEventHandler(api));
        log.info("正在启动中...");
        bot.start();
    }
}

@Slf4j
class IEventHandler extends EventHandler {
    private final ApiManager api;

    public IEventHandler(ApiManager api) {
        this.api = api;
    }

    @Override
    public void onAtMessage(AtMessageEvent event) {
        super.onAtMessage(event);
        Message message = event.getMessage();
        String channelId = message.getChannelId();
        String content = message.getContent();
        String messageId = message.getId();
        List<LinkText> linkTexts = new ArrayList<>();
        LinkText linkText = new LinkText();
        linkText.setDesc("纯文本测试");
        linkTexts.add(linkText);
        LinkText linkText2 = new LinkText();
        linkText2.setDesc("打开链接测试");
        linkText2.setLink("https://api.zplu.cc/jump");
        linkTexts.add(linkText2);
        MessageArk ark = LinkTextTemplate.builder()
                .prompt("提示信息")
                .desc("描述")
                .list(linkTexts)
                .build()
                .toMessageArk();
        if (content.contains("ping")) {
            Message result = api.getMessageApi()
                    .sendTemplateMessage(channelId, ark, messageId);
            log.info(result.toString());
        }
    }
}
