package me.zhenxin.qqbot.api;

import lombok.AllArgsConstructor;
import me.zhenxin.qqbot.api.impl.*;
import me.zhenxin.qqbot.entity.AccessInfo;

/**
 * API 管理器
 *
 * @author 真心
 * @since 2021/12/8 16:45
 */
@AllArgsConstructor
public class ApiManager {
    /**
     * 访问信息
     */
    private AccessInfo accessInfo;

    /**
     * 获取 消息API 实例
     */
    public MessageApi getMessageApi() {
        return new MessageApi(accessInfo);
    }

    /**
     * 获取 频道API 实例
     */
    public GuildApi getGuildApi() {
        return new GuildApi(accessInfo);
    }

    /**
     * 获取 子频道API 实例
     */
    public ChannelApi getChannelApi() {
        return new ChannelApi(accessInfo);
    }

    /**
     * 获取 子频道权限API 实例
     */
    public ChannelPermissionsApi getChannelPermissionsApi() {
        return new ChannelPermissionsApi(accessInfo);
    }

    /**
     * 获取 日程API 实例
     */
    public ScheduleApi getScheduleApi() {
        return new ScheduleApi(accessInfo);
    }

    /**
     * 获取 音频API 实例
     */
    public AudioApi getAudioApi() {
        return new AudioApi(accessInfo);
    }

    /**
     * 获取 身份组API 实例
     */
    public RoleApi getRoleApi() {
        return new RoleApi(accessInfo);
    }

    /**
     * 获取 成员API 实例
     */
    public MemberApi getMemberApi() {
        return new MemberApi(accessInfo);
    }

    /**
     * 获取 公告API 实例
     */
    public AnnouncesApi getAnnouncesApi() {
        return new AnnouncesApi(accessInfo);
    }

    /**
     * 获取 禁言API 实例
     */
    public MuteApi getMuteApi() {
        return new MuteApi(accessInfo);
    }

    /**
     * 获取 用户API 实例
     */
    public UserApi getUserApi() {
        return new UserApi(accessInfo);
    }
}
