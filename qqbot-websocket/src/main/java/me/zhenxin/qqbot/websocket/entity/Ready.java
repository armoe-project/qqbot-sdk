package me.zhenxin.qqbot.websocket.entity;

import me.zhenxin.qqbot.entity.User;
import lombok.Data;

import java.util.List;

/**
 * WS链接成功
 *
 * @author 真心
 * @since 2021/12/11 16:03
 */
@Data
public class Ready {
    private Integer version;
    private String sessionId;
    private User user;
    private List<Integer> shard;
}
