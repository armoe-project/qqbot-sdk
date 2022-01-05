package me.zhenxin.qqbot.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.Channel;
import me.zhenxin.qqbot.entity.Role;
import me.zhenxin.qqbot.entity.api.RoleList;
import me.zhenxin.qqbot.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

/**
 * 身份组相关接口
 *
 * @author 真心
 * @since 2021/12/11 11:02
 */
public class RoleApi extends BaseApi {
    public RoleApi(Boolean isSandBoxMode, String token) throws ApiException {
        super(isSandBoxMode, token);
    }

    /**
     * 获取身份组列表
     *
     * @param guildId 频道ID
     * @return 身份组列表(RoleList)对象
     */
    public RoleList getRoles(String guildId) throws ApiException {
        return get("/guilds/" + guildId + "/roles", RoleList.class);
    }

    /**
     * 创建身份组
     *
     * @param guildId 频道ID
     * @param name    身份组名称
     * @param color   身份组颜色 ARGB的HEX值
     * @param hoist   是否在成员列表单独显示
     */
    public Role createRole(String guildId, String name, Long color, Boolean hoist) throws ApiException {
        Map<String, Object> data = getData(name, color, hoist);
        JSONObject result = post("/guilds/" + guildId + "/roles", data, JSONObject.class);
        return JSON.toJavaObject(result.getJSONObject("role"), Role.class);
    }

    /**
     * 修改身份组
     *
     * @param guildId 频道ID
     * @param roleId  身份组ID
     * @param name    身份组名称
     * @param color   身份组颜色 ARGB的HEX值
     * @param hoist   是否在成员列表单独显示
     */
    public Role changeRole(String guildId, String roleId, String name, Long color, Boolean hoist) throws ApiException {
        Map<String, Object> data = getData(name, color, hoist);
        JSONObject result = patch("/guilds/" + guildId + "/roles/" + roleId, data, JSONObject.class);
        return JSON.toJavaObject(result.getJSONObject("role"), Role.class);
    }

    /**
     * 删除身份组
     *
     * @param guildId 频道ID
     * @param roleId  身份组ID
     */
    public void deleteRole(String guildId, String roleId) throws ApiException {
        delete("/guilds/" + guildId + "/roles/" + roleId, null);
    }

    /**
     * 增加身份组成员
     *
     * @param guildId   频道ID
     * @param userId    用户ID
     * @param roleId    身份组ID
     * @param channelId 子频道ID (如果roleId为5[子频道管理员]，则为设置的子频道。否则参数无效)
     */
    public void addRoleMember(String guildId, String userId, String roleId, String channelId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        if (channelId != null) {
            Channel channel = new Channel();
            channel.setId(channelId);
            data.put("channel", channel);
        }
        put("/guilds/" + guildId + "/members/" + userId + "/roles/" + roleId, data, null);
    }

    /**
     * 删除身份组成员
     *
     * @param guildId   频道ID
     * @param userId    用户ID
     * @param roleId    身份组ID
     * @param channelId 子频道ID (如果roleId为5[子频道管理员]，则为设置的子频道。否则参数无效)
     */
    public void deleteRoleMember(String guildId, String userId, String roleId, String channelId) throws ApiException {
        Map<String, Object> data = new HashMap<>();
        if (channelId != null) {
            Channel channel = new Channel();
            channel.setId(channelId);
            data.put("channel", channel);
        }
        delete("/guilds/" + guildId + "/members/" + userId + "/roles/" + roleId, data);
    }

    private Map<String, Object> getData(String name, Long color, Boolean hoist) {
        Filter filter = new Filter();
        if (name == null) filter.name = 0;
        if (color == null) filter.color = 0;
        if (hoist == null) hoist = false;
        if (!hoist) filter.hoist = 0;
        Info info = new Info();
        info.name = name;
        info.color = color;
        info.hoist = hoist ? 1 : 0;
        Map<String, Object> data = new HashMap<>();
        data.put("filter", filter);
        data.put("info", info);
        return data;
    }

    @Data
    private static class Filter {
        private Integer name = 1;
        private Integer color = 1;
        private Integer hoist = 1;
    }

    @Data
    private static class Info {
        private String name;
        private Long color;
        private Integer hoist;
    }
}
