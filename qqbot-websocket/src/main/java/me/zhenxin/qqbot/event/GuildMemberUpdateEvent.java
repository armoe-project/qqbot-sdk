package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Member;

import java.util.EventObject;

/**
 * 频道成员更新事件
 *
 * @author 真心
 * @since 2021/12/19 12:29
 */
@Getter
public class GuildMemberUpdateEvent extends EventObject {
    private final Member member;

    public GuildMemberUpdateEvent(Object source, Member member) {
        super(source);
        this.member = member;
    }
}
