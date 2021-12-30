package me.zhenxin.qqbot.core;

import me.zhenxin.qqbot.api.*;

/**
 * API 管理器
 *
 * @author 真心
 * @since 2021/12/8 16:45
 */
public class ApiManager {
    private Boolean useSandBoxMode;
    private String token;

    /**
     * API 管理器
     *
     * @param accessInfo 访问信息
     */
    protected ApiManager(AccessInfo accessInfo, Boolean useSandBoxMode) {
        this.useSandBoxMode = useSandBoxMode;
        Integer botAppId = accessInfo.getBotAppId();
        String botToken = accessInfo.getBotToken();
        this.token = "Bot " + botAppId + "." + botToken;
    }

    public ApiManager() {
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
     * 获取 子频道API 实例
     */
    public ChannelApi getChannelApi() {
        return new ChannelApi(useSandBoxMode, token);
    }

    /**
     * 获取 子频道权限API 实例
     */
    public ChannelPermissionsApi getChannelPermissionsApi() {
        return new ChannelPermissionsApi(useSandBoxMode, token);
    }

    /**
     * 获取 日程API 实例
     */
    public ScheduleApi getScheduleApi() {
        return new ScheduleApi(useSandBoxMode, token);
    }

    /**
     * 获取 音频API 实例
     */
    public AudioApi getAudioApi() {
        return new AudioApi(useSandBoxMode, token);
    }

    /**
     * 获取 身份组API 实例
     */
    public RoleApi getRoleApi() {
        return new RoleApi(useSandBoxMode, token);
    }

    /**
     * 获取 成员API 实例
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

    /**
     * 获取 禁言API 实例
     */
    public MuteApi getMuteApi() {
        return new MuteApi(useSandBoxMode, token);
    }

    /**
     * 获取 用户API 实例
     */
    public UserApi getUserApi() {
        return new UserApi(useSandBoxMode, token);
    }
}
