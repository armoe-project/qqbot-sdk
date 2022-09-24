package me.zhenxin.qqbot.entity.keyboard;

import lombok.Data;

import java.util.List;

/**
 * 消息按钮对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2022/9/24 10:17
 */
@Data
public class InlineKeyboard {
    /**
     * 消息按钮组件行
     */
    private List<InlineKeyboardRow> rows;
}
