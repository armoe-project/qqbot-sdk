/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
 * Copyright (C) 2022 xiaoye-bot Project Team
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

package me.zhenxin.qqbot.core;

import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.api.ApiManager;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.enums.Intent;
import me.zhenxin.qqbot.websocket.Client;
import me.zhenxin.qqbot.websocket.EventHandler;
import me.zhenxin.qqbot.websocket.entity.Gateway;
import okhttp3.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 机器人核心类
 *
 * @author 真心
 * @since 2021/12/9 0:58
 */
@SuppressWarnings("unused")
@Slf4j
public class BotCore {
    private final List<Intent> intents = new ArrayList<>();
    private final AccessInfo accessInfo;
    /**
     * 事件监听器
     */
    @Setter
    private EventHandler eventHandler = new EventHandler();

    /**
     * BotCore 机器人核心
     *
     * @param accessInfo 访问信息
     */
    public BotCore(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    private Gateway getGateway() {
        String token = getToken();
        String apiBase = getApiBase();

        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(apiBase + "/gateway/bot")
                .header("Authorization", token)
                .get()
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body == null) {
                System.exit(1);
            }
            String result = body.string();
            log.debug(result);
            return JSON.parseObject(result, Gateway.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    private String getToken() {
        return "Bot " + accessInfo.getBotAppId() + "." + accessInfo.getBotToken();
    }

    private String getApiBase() {
        String apiBase = "https://api.sgroup.qq.com";
        if (accessInfo.getUseSandBoxMode()) {
            apiBase = "https://sandbox.api.sgroup.qq.com";
        }
        return apiBase;
    }

    /**
     * 启动机器人 单例
     */
    public void start() {
        start(null, null);
    }

    /**
     * 启动机器人 指定分片
     *
     * @param shard      当前连接的分片数
     * @param totalShard 总分片数
     */
    public void start(Integer shard, Integer totalShard) {
        Gateway gateway = getGateway();
        if (gateway.getCode() == null) {
            String url = gateway.getUrl();
            log.info("网关地址: {}, 建议分片数: {}", url, gateway.getShards());
            try {
                Client client = new Client(new URI(url));
                client.setToken(getToken());
                client.setIntents(intents);
                client.setEventHandler(eventHandler);
                client.setShard(shard, totalShard);
                client.setConnectionLostTimeout(0);
                client.connect();
            } catch (URISyntaxException e) {
                log.error("WebSocket 连接地址错误!");
                System.exit(1);
            }
        } else {
            log.error("获取 Gateway 失败! {} {}", gateway.getCode(), gateway.getMessage());
            System.exit(gateway.getCode());
        }
    }

    /**
     * 使用沙箱模式
     *
     * @deprecated 使用 {@link AccessInfo#useSandBoxMode()} 替代
     */
    public void useSandBoxMode() {
        accessInfo.setUseSandBoxMode(true);
    }

    /**
     * 获取 API管理器 实例
     */
    public ApiManager getApiManager() {
        return new ApiManager(accessInfo);
    }

    /**
     * 注册事件订阅
     */
    public void registerIntents(Intent... intents) {
        this.intents.addAll(Arrays.asList(intents));
    }

    /**
     * 注册 频道相关 事件
     *
     * @deprecated 使用 {@link #registerIntents(Intent...)} 替代
     */
    public void registerGuildsEvent() {
        intents.add(Intent.GUILDS);
    }

    /**
     * 注册 频道成员相关 事件
     *
     * @deprecated 使用 {@link #registerIntents(Intent...)} 替代
     */
    public void registerGuildMembersEvent() {
        intents.add(Intent.GUILD_MEMBERS);
    }

    /**
     * 注册 私域消息 事件
     *
     * @deprecated 使用 {@link #registerIntents(Intent...)} 替代
     */
    public void registerUserMessagesEvent() {
        intents.add(Intent.USER_MESSAGES);
    }

    /**
     * 注册 消息表态 相关事件
     *
     * @deprecated 使用 {@link #registerIntents(Intent...)} 替代
     */
    public void registerGuildMessageReactionsEvent() {
        intents.add(Intent.GUILD_MESSAGE_REACTIONS);
    }

    /**
     * 注册 私聊消息 事件
     *
     * @deprecated 使用 {@link #registerIntents(Intent...)} 替代
     */
    public void registerDirectMessageEvent() {
        intents.add(Intent.DIRECT_MESSAGE);
    }

    /**
     * 注册 论坛相关 事件
     *
     * @deprecated 使用 {@link #registerIntents(Intent...)} 替代
     */
    public void registerForumEvent() {
        intents.add(Intent.FORUM_EVENT);
    }

    /**
     * 注册 音频相关 事件
     *
     * @deprecated 使用 {@link #registerIntents(Intent...)} 替代
     */
    public void registerAudioActionEvent() {
        intents.add(Intent.AUDIO_ACTION);
    }

    /**
     * 注册 AT消息 事件
     *
     * @deprecated 使用 {@link #registerIntents(Intent...)} 替代
     */
    public void registerAtMessageEvent() {
        intents.add(Intent.AT_MESSAGES);
    }
}
