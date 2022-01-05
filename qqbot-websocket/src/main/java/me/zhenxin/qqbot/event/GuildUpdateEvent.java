package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Guild;

import java.util.EventObject;

/**
 * 频道更新事件
 *
 * @author 真心
 * @since 2021/12/19 11:52
 */
@Getter
public class GuildUpdateEvent extends EventObject {
    private final Guild guild;

    public GuildUpdateEvent(Object source, Guild guild) {
        super(source);
        this.guild = guild;
    }
}
