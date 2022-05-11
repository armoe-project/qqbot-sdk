import lombok.extern.slf4j.Slf4j;
import lombok.val;
import me.zhenxin.qqbot.core.BotCore;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.enums.Intent;

/**
 * 示例程序
 *
 * @author 真心
 * @since 2021/12/8 15:41
 */
@Slf4j
class Example {
    public static void main(String[] args) throws InterruptedException {
        val accessInfo = new AccessInfo();
        accessInfo.setBotAppId(Integer.parseInt(System.getenv("BotAppid")));
        accessInfo.setBotToken(System.getenv("BotToken"));
        // accessInfo.useSandBoxMode();
        val bot = new BotCore(accessInfo);
        val api = bot.getApiManager();
        bot.registerIntents(
                Intent.GUILDS,
                Intent.GUILD_MEMBERS,
                Intent.GUILD_MESSAGE_REACTIONS,
                Intent.DIRECT_MESSAGE,
                Intent.FORUM_EVENT,
                // Intent.AT_MESSAGES
                Intent.MESSAGE_AUDIT,
                Intent.USER_MESSAGES
        );
        val handler = new IEventHandler(api);
        bot.setEventHandler(handler);
        log.info("正在启动中...");
        bot.start();
        // Thread.sleep(2000);
        // bot.start(1, 2);
    }
}
