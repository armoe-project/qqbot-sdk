package me.zhenxin.qqbot.pojo.ark;

import lombok.Data;

/**
 * Ark对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:33
 */
@Data
public class MessageArk {
    /**
     * 模板ID
     */
    private String templateId;
    private MessageAkrKv[] kv;
}
