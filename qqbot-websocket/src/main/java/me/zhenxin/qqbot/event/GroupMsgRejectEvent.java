package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Group;

import java.util.EventObject;

/**
 * 拒绝推送
 *
 * @author 真心
 * @since 2023/12/11 10:12
 */
@Getter
public class GroupMsgRejectEvent extends EventObject {
    private final Group group;

    public GroupMsgRejectEvent(Object source, Group group) {
        super(source);
        this.group = group;
    }
}
