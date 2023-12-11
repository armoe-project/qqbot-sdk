package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Group;

import java.util.EventObject;

/**
 * 加入群聊
 *
 * @author 真心
 * @since 2023/12/11 10:00
 */
@Getter
public class GroupAddRobotEvent extends EventObject {
    private final Group group;

    public GroupAddRobotEvent(Object source, Group group) {
        super(source);
        this.group = group;
    }
}
