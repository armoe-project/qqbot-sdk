package me.zhenxin.qqbot.websocket.entity;

import lombok.Data;

/**
 * Gateway 类
 *
 * @author 真心
 * @since 2021/12/9 2:06
 */
@Data
public class Gateway {
    private Integer code;
    private String message;
    private String url;
    private Integer shards;
    private SessionStartLimit sessionStartLimit;

    @Data
    public static class SessionStartLimit {
        private Integer total;
        private Integer remaining;
        private Integer resetAfter;
        private Integer maxConcurrency;
    }
}
