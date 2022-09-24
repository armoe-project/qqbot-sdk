package me.zhenxin.qqbot.entity.keyboard;

import java.util.List;

/**
 * 按钮权限
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2022/9/24 10:24
 */
public class Permission {
    /**
     * 权限类型
     * <ul>
     *     <li>0: 指定用户可操作</li>
     *     <li>1: 仅管理者可操作</li>
     *     <li>2: 所有人可操作</li>
     *     <li>3: 指定身份组可操作</li>
     * </ul>
     */
    private Integer type;
    /**
     *有权限的身份组id的列表
     */
    private List<String> specifyRoleIds;
    /**
     * 有权限的用户id的列表
     */
    private List<String> specifyUserIds;
}
