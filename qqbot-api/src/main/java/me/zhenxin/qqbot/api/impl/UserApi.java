package me.zhenxin.qqbot.api.impl;

import com.alibaba.fastjson.JSONArray;
import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.Guild;
import me.zhenxin.qqbot.entity.User;

import java.util.List;

/**
 * 用户相关接口
 *
 * @author 真心
 * @since 2021/12/28 10:59
 */
public class UserApi extends BaseApi {
    public UserApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
    }

    /**
     * 获取机器人信息
     *
     * @return 用户对象
     */
    public User getMeInfo() {
        return get("/users/@me", User.class);
    }

    /**
     * 获取机器人已加入频道列表
     *
     * @return 频道对象数组
     */
    public List<Guild> getMeGuilds() {
        JSONArray array = get("/users/@me/guilds", JSONArray.class);
        return array.toJavaList(Guild.class);
    }

    /**
     * 获取机器人已加入频道列表
     * <br/>
     * <span style="color: yellow;">before/after 参数仅能存在一个, 如果两个都存在，则会抛出异常</span>
     *
     * @param after  频道ID (读此ID之后的数据)
     * @param before 频道ID (读此ID之前的数据)
     * @return 频道对象数组
     */
    public List<Guild> getMeGuilds(String after, String before) {
        StringBuilder sb = new StringBuilder("/users/@me/guilds");
        if (before != null && after != null) {
            throw new IllegalArgumentException("before/after 参数仅能存在一个");
        }
        if (before != null) {
            sb.append("?before=").append(before);
        }
        if (after != null) {
            sb.append("?after=").append(after);
        }
        JSONArray array = get(sb.toString(), JSONArray.class);
        return array.toJavaList(Guild.class);
    }
}
