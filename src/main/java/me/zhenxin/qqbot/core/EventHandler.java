package me.zhenxin.qqbot.core;

import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;

/**
 * 事件处理器
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 12:19
 */
@Slf4j
public class EventHandler {
    /**
     * 艾特信息
     *
     * @param event 事件
     */
    public void onAtMessage(AtMessageEvent event) {
        log.info("收到艾特消息：" + event.getMessage().getContent());
    }

    /**
     * 用户消息
     *
     * @param event 事件
     */
    public void onUserMessage(UserMessageEvent event) {
        log.info("收到用户消息：" + event.getMessage().getContent());
    }
}
