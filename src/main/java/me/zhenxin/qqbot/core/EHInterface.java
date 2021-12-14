package me.zhenxin.qqbot.core;

import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件处理器接口
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/14 17:37
 */
interface EHInterface {
    /**
     * 艾特信息
     *
     * @param event 事件
     */
    default void onAtMessage(AtMessageEvent event) {
        Logger log = LoggerFactory.getLogger(EHInterface.class);
        log.info("收到艾特消息：" + event.getMessage().getContent());
    }

    /**
     * 用户消息
     *
     * @param event 事件
     */
    default void onUserMessage(UserMessageEvent event) {
        Logger log = LoggerFactory.getLogger(EHInterface.class);
        log.info("收到用户消息：" + event.getMessage().getContent());
    }
}
