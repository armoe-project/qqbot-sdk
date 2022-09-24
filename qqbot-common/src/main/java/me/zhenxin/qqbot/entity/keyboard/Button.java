package me.zhenxin.qqbot.entity.keyboard;

import lombok.Data;

/**
 * 按钮
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2022/9/24 10:19
 */
@Data
public class Button {
    /**
     * 按钮ID
     */
    private String id;
    /**
     * 按钮渲染展示
     */
    private RenderData renderData;
    /**
     * 按钮操作
     */
    private Action action;
}
