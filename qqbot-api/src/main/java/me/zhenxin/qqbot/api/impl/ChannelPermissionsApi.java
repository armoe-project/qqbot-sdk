package me.zhenxin.qqbot.api.impl;

import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.ChannelPermissions;

import java.util.HashMap;
import java.util.Map;

/**
 * 子频道权限相关接口
 *
 * @author 真心
 * @since 2021/12/24 10:28
 */
public class ChannelPermissionsApi extends BaseApi {
    public ChannelPermissionsApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 获取子频道权限
     *
     * @param channelId 子频道ID
     * @param userId    用户ID
     * @return 子频道权限对象
     */
    public ChannelPermissions getChannelPermissions(String channelId, String userId) {
        return get("/channels/" + channelId + "/members/" + userId + "/permissions", ChannelPermissions.class);
    }

    /**
     * 添加子频道权限
     *
     * @param channelId   子频道ID
     * @param userId      用户ID
     * @param permissions 权限 <a href="https://bot.q.qq.com/wiki/develop/api/openapi/channel_permissions/model.html#permissions">权限列表</a>
     */
    public void addChannelPermissions(String channelId, String userId, Integer permissions) {
        Map<String, Object> data = new HashMap<>();
        data.put("add", permissions.toString());
        put("/channels/" + channelId + "/members/" + userId + "/permissions", data, null);
    }

    /**
     * 移除子频道权限
     *
     * @param channelId   子频道ID
     * @param userId      用户ID
     * @param permissions 权限 <a href="https://bot.q.qq.com/wiki/develop/api/openapi/channel_permissions/model.html#permissions">权限列表</a>
     */
    public void removeChannelPermissions(String channelId, String userId, Integer permissions) {
        Map<String, Object> data = new HashMap<>();
        data.put("remove", permissions.toString());
        put("/channels/" + channelId + "/members/" + userId + "/permissions", data, null);
    }
}
