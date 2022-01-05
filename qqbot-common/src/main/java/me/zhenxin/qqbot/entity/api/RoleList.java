package me.zhenxin.qqbot.entity.api;

import lombok.Data;
import me.zhenxin.qqbot.entity.Role;

import java.util.List;

/**
 * 身份组列表
 *
 * @author 真心
 * @since 2021/12/11 11:04
 */
@Data
public class RoleList {
    /**
     * 频道ID
     */
    private String guildId;
    /**
     * 身份组列表
     */
    private List<Role> roles;
    /**
     * 默认分组上限
     */
    private Integer roleNumLimit;
}
