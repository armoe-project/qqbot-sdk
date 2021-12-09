package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.pojo.Message;

import java.util.EventObject;

/**
 * 用户消息事件
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 12:43
 */
@Getter
public class UserMessageEvent extends EventObject {
    private final Message message;

    public UserMessageEvent(Object source, Message message) {
        super(source);
        this.message = message;
    }
}
