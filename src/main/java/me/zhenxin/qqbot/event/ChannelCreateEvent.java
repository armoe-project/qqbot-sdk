package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Channel;

import java.util.EventObject;

/**
 * 子频道创建事件
 *
 * @author 真心
 * @since 2021/12/19 11:58
 */
@Getter
public class ChannelCreateEvent extends EventObject {
    private final Channel channel;

    public ChannelCreateEvent(Object source, Channel channel) {
        super(source);
        this.channel = channel;
    }
}
