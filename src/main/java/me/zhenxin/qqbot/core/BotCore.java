package me.zhenxin.qqbot.core;

import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.ws.Gateway;
import me.zhenxin.qqbot.enums.Intent;
import okhttp3.*;

import java.io.IOException;
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
                .url(apiBase + "/gateway")
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
            return JSON.parseObject(body.string(), Gateway.class);
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
        if (accessInfo.getUseSandBoxMode()) apiBase = "https://sandbox.api.sgroup.qq.com";
        return apiBase;
    }

    /**
     * 启动机器人
     */
    public void start() {
        Gateway gateway = getGateway();
        if (gateway.getCode() == null) {
            String url = gateway.getUrl();
            log.debug(url);
            WSClient client = new WSClient(url);
            client.setToken(getToken());
            client.setIntents(intents);
            client.setEventHandler(eventHandler);
            client.connect();
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
        return new ApiManager(accessInfo, accessInfo.getUseSandBoxMode());
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
