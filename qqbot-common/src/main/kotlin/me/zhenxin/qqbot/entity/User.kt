package me.zhenxin.qqbot.entity

import com.alibaba.fastjson2.annotation.JSONField

/**
 * 用户
 *
 * @author 真心
 * @since 2023/10/6 17:06
 */
data class User(
    /**
     * 用户 ID
     */
    var id: Long = 0,
    /**
     * 用户名
     */
    var username: String = "",
    /**
     * 用户的头像地址
     */
    var avatar: String = "",
    /**
     * 是否是机器人
     */
    var bot: Boolean = false,
    /**
     * UnionOpenId
     */
    @JSONField(name = "union_openid")
    var unionOpenId: String = "",
    /**
     * UnionUserAccount
     */
    var unionUserAccount: String = "",
)
