/*
 * QQBot SDK - QQ Official Bot SDK
 * Copyright (C) 2023 ZhenXin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
        botSecret = System.getenv("BOT_SECRET") ?: ""
        isSandbox = System.getenv("IS_SANDBOX")?.toBoolean() ?: true
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