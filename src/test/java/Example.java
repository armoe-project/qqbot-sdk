import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.core.AccessInfo;
import me.zhenxin.qqbot.core.ApiManager;
import me.zhenxin.qqbot.core.BotCore;
import me.zhenxin.qqbot.enums.Intent;

/**
 * 示例程序
 *
 * @author 真心
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
        bot.registerIntents(
                Intent.GUILDS,
                Intent.GUILD_MEMBERS,
                Intent.GUILD_MESSAGE_REACTIONS,
                //  Intent.FORUM_EVENT,
                Intent.AT_MESSAGES,
                Intent.USER_MESSAGES
        );
        IEventHandler handler = new IEventHandler(api);
        bot.setEventHandler(handler);
        log.info("正在启动中...");
        bot.start();
    }
}
