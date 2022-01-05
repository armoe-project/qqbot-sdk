package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Channel;

import java.util.EventObject;

/**
 * 子频道删除事件
 *
 * @author 真心
 * @since 2021/12/19 12:00
 */
@Getter
public class ChannelDeleteEvent extends EventObject {
    private final Channel channel;

    public ChannelDeleteEvent(Object source, Channel channel) {
        super(source);
        this.channel = channel;
    }
}
