package me.zhenxin.qqbot.entity.ark;

import lombok.Data;

import java.util.List;

/**
 * ArkKv对象
 *
 * @author 真心
 * @since 2021/12/8 16:34
 */
@Data
public class MessageArkKv {
    private String key;
    private String value;
    private List<MessageArkObj> obj;
}
