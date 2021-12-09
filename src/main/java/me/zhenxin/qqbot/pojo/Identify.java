package me.zhenxin.qqbot.pojo;

import lombok.Data;

/**
 * Identify 鉴权类
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 2:18
 */
@Data
public class Identify {
    private String token;
    private Integer intents;
    private Integer[] shard = {0, 1};
}
