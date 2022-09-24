package me.zhenxin.qqbot.entity.keyboard;

import lombok.Data;

import java.util.List;

/**
 * 消息按钮组件行
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2022/9/24 10:18
 */
@Data
public class InlineKeyboardRow {
    /**
     * 按钮对象
     */
    private List<Button> buttons;
}
