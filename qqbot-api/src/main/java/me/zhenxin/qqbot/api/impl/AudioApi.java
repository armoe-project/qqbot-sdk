package me.zhenxin.qqbot.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

    /**
     * 音频控制
     *
     * @param channelId 子频道ID
     * @param control   音频控制对象
     */
    public void audioControl(String channelId, AudioControl control) {
        post("/channels/" + channelId + "/audio", (JSONObject) JSON.toJSON(control), null);
    }
}
