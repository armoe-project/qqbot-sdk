package me.zhenxin.qqbot.pojo.ark;

import lombok.Data;

/**
 * ArkKv对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:34
 */
@Data
public class MessageAkrKv {
    private String key;
    private String value;
    private MessageArkObj[] obj;
}
