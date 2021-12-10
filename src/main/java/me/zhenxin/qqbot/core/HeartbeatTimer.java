package me.zhenxin.qqbot.core;

import java.util.TimerTask;

/**
 * 心跳计时器
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 11:34
 */
class HeartbeatTimer extends TimerTask {
    private final WSSClient wssClient;

    public HeartbeatTimer(WSSClient wssClient) {
        this.wssClient = wssClient;
    }

    @Override
    public void run() {
        wssClient.sendHeartbeat();
    }
}
