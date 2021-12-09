package me.zhenxin.qqbot.core;

import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;

/**
 * 事件处理器
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 12:19
 */
public class EventHandler {
    /**
     * 艾特信息
     * @param event 事件
     */
    public void onAtMessage(AtMessageEvent event) {
        System.out.println("收到@消息：" + event.getMessage().getContent());
    }

    /**
     * 用户消息
     * @param event 事件
     */
    public void onUserMessage(UserMessageEvent event) {
        System.out.println("收到用户消息：" + event.getMessage().getContent());
    }
}
