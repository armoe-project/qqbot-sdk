package me.zhenxin.qqbot.core;

import lombok.Setter;
import me.zhenxin.qqbot.entity.User;

/**
 * 事件处理器
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 12:19
 */
public class EventHandler implements EHInterface {
    /**
     * 机器人本身的用户信息
     */
    @Setter
    protected User me;
}
