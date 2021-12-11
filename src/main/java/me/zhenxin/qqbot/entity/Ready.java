package me.zhenxin.qqbot.entity;

import lombok.Data;

import java.util.List;

/**
 * WS链接成功
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/11 16:03
 */
@Data
public class Ready {
    private Integer version;
    private String sessionId;
    private User user;
    private List<Integer> shard;
}
