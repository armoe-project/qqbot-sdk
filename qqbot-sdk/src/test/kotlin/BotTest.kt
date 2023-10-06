import io.github.oshai.kotlinlogging.KotlinLogging
import me.zhenxin.qqbot.BotCore
import me.zhenxin.qqbot.entity.AccessInfo
import me.zhenxin.qqbot.enums.Intent
import me.zhenxin.qqbot.exception.ApiException

val logger = KotlinLogging.logger {}

/**
 * 机器人测试
 *
 * @author 真心
 * @since 2023/10/1 13:49
 */

fun main() {
    val accessInfo = AccessInfo().apply {
        botAppId = System.getenv("BOT_APP_ID")?.toInt() ?: 0
        botToken = System.getenv("BOT_TOKEN") ?: ""
    }

    try {
        val bot = BotCore(accessInfo)
        bot.registerIntents(
            Intent.GUILDS,
            Intent.GUILD_MEMBERS,
            Intent.GUILD_MESSAGE_REACTIONS,
            Intent.DIRECT_MESSAGE,
            Intent.OPEN_FORUMS_EVENTS,
            Intent.AUDIO_OR_LIVE_CHANNEL_MEMBERS,
            Intent.INTERACTION,
            Intent.MESSAGE_AUDIT,
            Intent.PUBLIC_GUILD_MESSAGES,
        )
        bot.start()
    } catch (e: ApiException) {
        logger.debug { "ApiException: ${e.code} ${e.message} ${e.detail} ${e.traceId}" }
        e.printStackTrace()
    }
}