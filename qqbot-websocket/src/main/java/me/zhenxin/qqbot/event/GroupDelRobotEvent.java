package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.Group;

import java.util.EventObject;

/**
 * 离开群聊
 *
 * @author 真心
 * @since 2023/12/11 10:05
 */
@Getter
public class GroupDelRobotEvent extends EventObject {
    private final Group group;

    public GroupDelRobotEvent(Object source, Group group) {
        super(source);
        this.group = group;
    }
}
