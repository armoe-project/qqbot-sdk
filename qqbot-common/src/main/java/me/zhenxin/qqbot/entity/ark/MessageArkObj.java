package me.zhenxin.qqbot.entity.ark;

import lombok.Data;

import java.util.List;

/**
 * ArkObj对象
 *
 * @author 真心
 * @since 2021/12/8 16:35
 */
@Data
public class MessageArkObj {
    private List<MessageArkObjKv> objKv;
}
