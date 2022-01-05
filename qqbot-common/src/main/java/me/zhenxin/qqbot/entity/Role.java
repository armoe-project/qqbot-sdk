package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 身份组对象
 *
 * @author 真心
 * @since 2021/12/11 21:35
 */
@Data
public class Role {
    /**
     * 身份组ID
     * <pre>
     * 1 - 全体成员
     * 2 - 管理员
     * 4 - 创建者
     * 5 - 子频道管理员
     * 其他 - 用户创建的身份组ID
     * </pre>
     */
    private String id;
    /**
     * 身份组名称
     */
    private String name;
    /**
     * 身份组颜色
     */
    private Long color;
    /**
     * 是否在成员列表中显示
     */
    private Integer hoist;
    /**
     * 人数
     */
    private Integer number;
    /**
     * 成员上限
     */
    private Integer memberLimit;
}
