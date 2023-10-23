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
