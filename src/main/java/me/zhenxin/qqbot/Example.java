package me.zhenxin.qqbot;

import me.zhenxin.qqbot.core.AccessInfo;
import me.zhenxin.qqbot.core.ApiManager;
import me.zhenxin.qqbot.core.BotCore;
import me.zhenxin.qqbot.core.EventHandler;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.pojo.Message;

/**
 * 示例程序
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 15:41
 */
class Example {
    public static void main(String[] args) {
        AccessInfo accessInfo = new AccessInfo();
        accessInfo.setBotAppId(Integer.parseInt(System.getenv("BotAppid")));
        accessInfo.setBotToken(System.getenv("BotToken"));
        accessInfo.setUseSandBoxMode(true);
        BotCore bot = new BotCore(accessInfo);
        ApiManager api = bot.getApiManager();
        bot.registerAtMessageEvent();
        bot.setEventHandler(new IEventHandler(api));
        bot.start();
    }
}

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
        if (content.contains("ping")) {
            Message result = api.getMessageApi()
                    .sendTextMessage(channelId, "pong!", messageId);
            System.out.println(result);
        }
    }
}
