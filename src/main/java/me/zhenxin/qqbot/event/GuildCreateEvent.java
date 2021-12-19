package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Guild;

import java.util.EventObject;

/**
 * 频道新增事件
 *
 * @author 真心
 * @since 2021/12/19 11:50
 */
@Getter
public class GuildCreateEvent extends EventObject {
    private final Guild guild;

    public GuildCreateEvent(Object source, Guild guild) {
        super(source);
        this.guild = guild;
    }
}
