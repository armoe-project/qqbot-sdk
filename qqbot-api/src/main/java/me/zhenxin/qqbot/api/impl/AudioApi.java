package me.zhenxin.qqbot.api.impl;

import cn.hutool.core.bean.BeanUtil;
import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AudioControl;

/**
 * 音频相关接口
 *
 * @author 真心
 * @since 2021/12/19 15:52
 */
public class AudioApi extends BaseApi {
    public AudioApi(Boolean isSandBoxMode, String token) {
        super(isSandBoxMode, token);
    }

    public void AudioControl(String channelId, AudioControl control) {
        post("/channels/" + channelId + "/audio", BeanUtil.beanToMap(control), null);
    }
}
