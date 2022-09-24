package me.zhenxin.qqbot.entity.keyboard;

import lombok.Data;

/**
 * 按钮渲染展示对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2022/9/24 10:20
 */
@Data
public class RenderData {
    /**
     * 按纽上的文字
     */
    private String label;
    /**
     * 点击后按纽上文字
     */
    private String visitedLabel;
    /**
     * 按钮样式
     * <ul>
     *     <li>0: 灰色线框</li>
     *     <li>1: 蓝色线框</li>
     * </ul>
     */
    private Integer style;
}
