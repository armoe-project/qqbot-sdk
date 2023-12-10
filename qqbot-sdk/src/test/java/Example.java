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
                // Intent.GUILD_MESSAGES,
                Intent.GUILD_MESSAGE_REACTIONS,
                Intent.DIRECT_MESSAGE,
                Intent.GROUP_MESSAGE,
                Intent.INTERACTION,
                Intent.MESSAGE_AUDIT,
                // Intent.FORUM_EVENT,
                Intent.PUBLIC_GUILD_MESSAGES
        );
        val handler = new IEventHandler(api);
        // bot.setEventHandler(handler);
        log.info("正在启动中...");
        bot.start();
    }
}
