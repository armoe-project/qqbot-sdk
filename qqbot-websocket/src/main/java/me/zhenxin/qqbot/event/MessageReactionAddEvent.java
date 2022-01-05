package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.MessageReaction;

import java.util.EventObject;

/**
 * 表态添加事件
 *
 * @author 真心
 * @since 2021/12/19 16:03
 */
@Getter
public class MessageReactionAddEvent extends EventObject {
    private final MessageReaction reaction;

    public MessageReactionAddEvent(Object source, MessageReaction reaction) {
        super(source);
        this.reaction = reaction;
    }
}
