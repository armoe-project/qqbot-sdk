package me.zhenxin.qqbot.pojo;

import lombok.Data;

/**
 * Gateway 类
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 2:06
 */
@Data
public class Gateway {
    private Integer code;
    private String message;
    private String url;
}
