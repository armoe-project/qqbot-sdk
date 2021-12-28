package me.zhenxin.qqbot.api;

import cn.hutool.json.JSONArray;
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
        return array.toList(Guild.class);
    }
}
