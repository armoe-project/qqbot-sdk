package me.zhenxin.qqbot.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 成员对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:29
 */
@Data
public class Member {
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 用户基础信息
     */
    private User user;
    /**
     * 用户在频道内的昵称
     */
    private String nick;
    /**
     * 用户在频道内的身份组ID
     */
    private String[] roles;
    /**
     * 用户加入频道的时间
     */
    private LocalDateTime joinedAt;
}
