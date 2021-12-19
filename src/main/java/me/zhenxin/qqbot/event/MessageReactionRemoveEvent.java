package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.MessageReaction;

import java.util.EventObject;

/**
 * 表态移除
 *
 * @author 真心
 * @since 2021/12/19 16:04
 */
@Getter
public class MessageReactionRemoveEvent extends EventObject {
    private final MessageReaction reaction;

    public MessageReactionRemoveEvent(Object source, MessageReaction reaction) {
        super(source);
        this.reaction = reaction;
    }
}
