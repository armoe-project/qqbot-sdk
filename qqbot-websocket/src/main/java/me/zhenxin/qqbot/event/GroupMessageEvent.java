package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Message;

import java.util.EventObject;

/**
 * 群聊消息事件
 *
 * @author 真心
 * @since 2023/12/10 17:30
 */
@Getter
public class GroupMessageEvent extends EventObject {
    private final Message message;

    public GroupMessageEvent(Object source, Message message) {
        super(source);
        this.message = message;
    }
}
