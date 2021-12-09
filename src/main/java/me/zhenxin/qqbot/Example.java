package me.zhenxin.qqbot;

import me.zhenxin.qqbot.core.AccessInfo;
import me.zhenxin.qqbot.core.ApiManager;
import me.zhenxin.qqbot.core.BotCore;
import me.zhenxin.qqbot.core.EventHandler;
import me.zhenxin.qqbot.event.AtMessageEvent;

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
        accessInfo.setBotSecret(System.getenv("BotSecret"));
        BotCore bot = new BotCore(accessInfo);
        ApiManager api = bot.getApiManager();
        bot.registerAtMessageEvent();
        bot.registerMessagesEvent();
        bot.setEventHandler(new IEventHandler());
        bot.start();
    }
}

class IEventHandler extends EventHandler {

    @Override
    public void onAtMessage(AtMessageEvent event) {
        super.onAtMessage(event);
        System.out.println(event.getMessage().getMentionEveryone());
    }
}
