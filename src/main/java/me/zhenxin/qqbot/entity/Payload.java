package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * Payload
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 2:15
 */
@Data
public class Payload {
    private Integer op;
    private Object d;
    private Integer s;
    private String t;
}
