package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Channel;

import java.util.EventObject;

/**
 * 子频道更新事件
 *
 * @author 真心
 * @since 2021/12/19 11:59
 */
@Getter
public class ChannelUpdateEvent extends EventObject {
    private final Channel channel;

    public ChannelUpdateEvent(Object source, Channel channel) {
        super(source);
        this.channel = channel;
    }
}
