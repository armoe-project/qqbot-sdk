package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Member;

import java.util.EventObject;

/**
 * 频道成员移除事件
 *
 * @author 真心
 * @since 2021/12/19 12:29
 */
@Getter
public class GuildMemberRemoveEvent extends EventObject {
    private final Member member;

    public GuildMemberRemoveEvent(Object source, Member member) {
        super(source);
        this.member = member;
    }
}
