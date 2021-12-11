package me.zhenxin.qqbot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 子频道子类型
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/11 13:02
 */
@Getter
@AllArgsConstructor
public enum ChannelSubType {
    /**
     * 闲聊
     */
    CHAT(0),
    /**
     * 公告
     */
    NOTICE(1),
    /**
     * 攻略
     */
    HELP(2),
    /**
     * 开黑
     */
    GANG(3);
    private final Integer value;
}
