import me.zhenxin.qqbot.BotCore;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.enums.Intent;

/**
 * 机器人测试类
 *
 * @author 真心
 * @since 2023/10/6 11:27
 */
public class BotTest {

    public static void main(String[] args) {
        String botAppId = System.getenv("BOT_APP_ID");
        String botToken = System.getenv("BOT_TOKEN");

        AccessInfo accessInfo = new AccessInfo();
        accessInfo.setBotAppId(Integer.parseInt(botAppId));
        accessInfo.setBotToken(botToken);
        accessInfo.setSandbox(true);

        BotCore bot = new BotCore(accessInfo);
        bot.registerIntents(
                Intent.GUILDS,
                Intent.GUILD_MEMBERS,
                Intent.GUILD_MESSAGE_REACTIONS,
                Intent.DIRECT_MESSAGE,
                Intent.OPEN_FORUMS_EVENTS,
                Intent.AUDIO_OR_LIVE_CHANNEL_MEMBERS,
                Intent.INTERACTION,
                Intent.MESSAGE_AUDIT,
                Intent.PUBLIC_GUILD_MESSAGES
        );
        bot.start();
    }
}
