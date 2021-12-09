package me.zhenxin.qqbot.core;

import me.zhenxin.qqbot.api.MessageApi;

/**
 * API 管理器
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:45
 */
public class ApiManager {
    private final Boolean useSandBoxMode;
    private final String token;

    /**
     * API 管理器
     *
     * @param accessInfo 访问信息
     */
    protected ApiManager(AccessInfo accessInfo) {
        this.useSandBoxMode = accessInfo.getUseSandBoxMode();
        Integer botAppId = accessInfo.getBotAppId();
        String botToken = accessInfo.getBotToken();
        this.token = "Bot " + botAppId + "." + botToken;
    }

    /**
     * 获取 消息API 实例
     */
    public MessageApi getMessageApi() {
        return new MessageApi(useSandBoxMode, token);
    }
}
