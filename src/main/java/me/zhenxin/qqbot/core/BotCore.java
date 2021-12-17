package me.zhenxin.qqbot.core;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.ws.Gateway;
import me.zhenxin.qqbot.enums.Intent;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

        HttpRequest request = HttpRequest.get(apiBase + "/gateway");
        request.header("Authorization", token);
        HttpResponse response = request.execute();
        return JSONUtil.toBean(response.body(), Gateway.class);
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
            try {
                WSClient client = new WSClient(new URI(url));
                client.setToken(getToken());
                client.setIntents(intents);
                client.setEventHandler(eventHandler);
                client.setConnectionLostTimeout(0);
                client.connect();
            } catch (URISyntaxException e) {
                log.error("WS链接格式错误!");
                System.exit(1);
            }
        }
    }

    /**
     * 获取 API管理器 实例
     */
    public ApiManager getApiManager() {
        return new ApiManager(accessInfo, accessInfo.getUseSandBoxMode());
    }

    /**
     * 注册 频道相关 事件
     */
    public void registerGuildsEvent() {
        intents.add(Intent.GUILDS);
    }

    /**
     * 注册 频道成员相关 事件
     */
    public void registerGuildMembersEvent() {
        intents.add(Intent.GUILD_MEMBERS);
    }

    /**
     * 注册 私域消息事件
     */
    public void registerUserMessagesEvent() {
        intents.add(Intent.MESSAGES);
    }

    /**
     * 注册 消息表态 相关事件
     */
    public void registerGuildMessageReactionsEvent() {
        intents.add(Intent.GUILD_MESSAGE_REACTIONS);
    }

    /**
     * 注册 私聊消息事件
     */
    public void registerDirectMessageEvent() {
        intents.add(Intent.DIRECT_MESSAGE);
    }

    /**
     * 注册 音频相关 事件
     */
    public void registerAudioActionEvent() {
        intents.add(Intent.AUDIO_ACTION);
    }

    /**
     * 注册 AT消息 事件
     */
    public void registerAtMessageEvent() {
        intents.add(Intent.AT_MESSAGES);
    }
}
