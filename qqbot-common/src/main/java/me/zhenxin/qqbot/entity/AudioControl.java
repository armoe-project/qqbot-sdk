package me.zhenxin.qqbot.entity;

import lombok.Data;

/**
 * 音频控制对象
 *
 * @author 真心
 * @since 2021/12/19 13:11
 */
@Data
public class AudioControl {
    /**
     * 音频数据的url 可选, status为0时传入
     */
    private String audioUrl;
    /**
     * 状态文本 可选, status为0时传入
     */
    private String text;
    /**
     * 播放状态
     */
    private Integer status;
}
