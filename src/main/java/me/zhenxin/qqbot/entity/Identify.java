package me.zhenxin.qqbot.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> shard = new ArrayList<>();
}
