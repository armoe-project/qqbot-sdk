package me.zhenxin.qqbot.entity.ws;

import lombok.Data;
import me.zhenxin.qqbot.entity.User;

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
