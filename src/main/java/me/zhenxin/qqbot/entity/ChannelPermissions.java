package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 子频道权限
 *
 * @author 真心
 * @since 2021/12/24 10:25
 */
@Data
public class ChannelPermissions {
    /**
     * 子频道ID
     */
    private String channelId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户拥有的子频道权限权限
     * <br/>
     * <a href="https://bot.q.qq.com/wiki/develop/api/openapi/channel_permissions/model.html#permissions">权限列表</a>
     */
    private String permissions;
}
