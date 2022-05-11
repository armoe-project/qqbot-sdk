/*
 * qq-official-bot-sdk - QQ Official Bot SDK For Java
 * Copyright (C) 2021-2022 xiaoye-bot Project Team
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
     * 获取 表情表态API 实例
     */
    public MessageReactionApi getMessageReactionApi() {
        return new MessageReactionApi(accessInfo);
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
     * 获取 精华消息API 实例
     */
    public PinsMessageApi getPinsMessageApi() {
        return new PinsMessageApi(accessInfo);
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

    /**
     * 获取 私信API 实例
     */
    public DirectMessageApi getDirectMessageApi() {
        return new DirectMessageApi(accessInfo);
    }
}
