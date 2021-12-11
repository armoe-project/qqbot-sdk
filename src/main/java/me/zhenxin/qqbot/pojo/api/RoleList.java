package me.zhenxin.qqbot.pojo.api;

import lombok.Data;

import javax.management.relation.Role;
import java.util.List;

/**
 * 身份组列表
 *
 * @author 真心
 * @email qgzhenxin@qq.com
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
