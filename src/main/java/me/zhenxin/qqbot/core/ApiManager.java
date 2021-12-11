package me.zhenxin.qqbot.core;

import me.zhenxin.qqbot.api.*;

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

    /**
     * 获取 频道API 实例
     */
    public GuildApi getGuildApi() {
        return new GuildApi(useSandBoxMode, token);
    }

    /**
     * 获取 身份组API 实例
     */
    public RoleApi getRoleApi() {
        return new RoleApi(useSandBoxMode, token);
    }

    /**
     * 获取 成员API 实例
     *
     */
    public MemberApi getMemberApi() {
        return new MemberApi(useSandBoxMode, token);
    }

    /**
     * 获取 公告API 实例
     */
    public AnnouncesApi getAnnouncesApi() {
        return new AnnouncesApi(useSandBoxMode, token);
    }
}
