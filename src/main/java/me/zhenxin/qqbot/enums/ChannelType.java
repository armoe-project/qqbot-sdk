package me.zhenxin.qqbot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 子频道类型
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/11 12:55
 */
@Getter
@AllArgsConstructor
public enum ChannelType {
    /**
     * 文字子频道
     */
    TEXT(0),
    /**
     * 语音子频道
     */
    VOICE(2),
    /**
     * 子频道分组
     */
    GROUP(4),
    /**
     * 直播子频道
     */
    LIVE(10005),
    /**
     * 应用子频道
     */
    APP(10006),
    /**
     * 论坛子频道
     */
    BBS(10007);
    private final Integer value;
}
