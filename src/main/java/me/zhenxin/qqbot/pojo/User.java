package me.zhenxin.qqbot.pojo;

import lombok.Data;

/**
 * 用户对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:26
 */
@Data
public class User {
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户头像地址
     */
    private String avatar;
    /**
     * 是否是机器人
     */
    private Boolean bot;
    /**
     * 特殊关联应用的 openid
     */
    private String unionOpenId;
    /**
     * 机器人关联的互联应用的用户信息
     */
    private String unionUserAccount;
}
