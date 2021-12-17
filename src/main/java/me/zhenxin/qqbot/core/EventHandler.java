package me.zhenxin.qqbot.core;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.User;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;

/**
 * 事件处理器
 *
 * @author 真心
 * @since 2021/12/9 12:19
 */
@Slf4j
public class EventHandler {
    /**
     * 机器人本身的用户信息
     */
    @Setter
    protected User me;
    /**
     * 是否去除消息中的@机器人
     */
    @Getter
    @Setter
    private boolean removeAt = true;

    /**
     * 艾特信息
     *
     * @param event 事件
     */
    protected void onAtMessage(AtMessageEvent event) {
        Message message = event.getMessage();
        log.info(
                "[AtMessage]: 频道({}) 子频道({}) {}({}): {}",
                message.getGuildId(),
                message.getChannelId(),
                message.getAuthor().getUsername(),
                message.getAuthor().getId(),
                message.getContent()
        );
    }

    /**
     * 用户消息
     *
     * @param event 事件
     */
    protected void onUserMessage(UserMessageEvent event) {
        Message message = event.getMessage();
        log.info(
                "[UserMessage]: 频道({}) 子频道({}) {}({}): {}",
                message.getGuildId(),
                message.getChannelId(),
                message.getAuthor().getUsername(),
                message.getAuthor().getId(),
                message.getContent()
        );
    }
}
