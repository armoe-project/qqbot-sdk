package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Guild;

import java.util.EventObject;

/**
 * 频道删除事件
 *
 * @author 真心
 * @since 2021/12/19 11:53
 */
@Getter
public class GuildDeleteEvent extends EventObject {
    private final Guild guild;

    public GuildDeleteEvent(Object source, Guild guild) {
        super(source);
        this.guild = guild;
    }
}
