package me.zhenxin.qqbot.core;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.User;
import me.zhenxin.qqbot.entity.ws.Hello;
import me.zhenxin.qqbot.entity.ws.Identify;
import me.zhenxin.qqbot.entity.ws.Payload;
import me.zhenxin.qqbot.entity.ws.Ready;
import me.zhenxin.qqbot.enums.Intent;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;
import org.java_websocket.enums.ReadyState;

import java.util.Timer;
import java.util.TimerTask;

/**
 * WebSocket 事件
 *
 * @author 真心
 * @since 2021/12/17 13:05
 */
@Slf4j
class WSEvent {
    @Setter
    WSClient client;
    private Timer timer;
    private String sessionId;
    private User me;

    // OP 0
    public void onDispatch(Payload payload) {
        String e = payload.getT();
        switch (e) {
            case "READY":
                Ready ready = JSONUtil.toBean((JSONObject) payload.getD(), Ready.class);
                sessionId = ready.getSessionId();
                client.getEventHandler().setMe(ready.getUser());
                me = ready.getUser();
                log.info("机器人已上线!");
                break;
            case "AT_MESSAGE_CREATE":
                Message atMessage = JSONUtil.toBean((JSONObject) payload.getD(), Message.class);
                if (client.getEventHandler().isRemoveAt()) {
                    atMessage.setContent(atMessage.getContent().replaceAll("<@!" + me.getId() + "> ", ""));
                    atMessage.setContent(atMessage.getContent().replaceAll("<@!" + me.getId() + ">", ""));
                }
                AtMessageEvent atMessageEvent = new AtMessageEvent(this, atMessage);
                client.getEventHandler().onAtMessage(atMessageEvent);
                break;
            case "MESSAGE_CREATE":
                Message userMessage = JSONUtil.toBean((JSONObject) payload.getD(), Message.class);
                UserMessageEvent userMessageEvent = new UserMessageEvent(this, userMessage);
                client.getEventHandler().onUserMessage(userMessageEvent);
                break;
            case "RESUMED":
                log.info("恢复连接成功, 离线消息已处理!");
                break;
            default:
                log.warn("未知事件: " + e);
        }
    }

    // OP 7
    public void onReconnect() {
        log.info("服务端通知客户端重连!");
    }

    // OP 9
    public void onInvalidSession() {
        log.error("鉴权失败!");
        System.exit(1);
    }

    // OP 10
    public void onHello(Payload payload) {
        Hello hello = JSONUtil.toBean((JSONObject) payload.getD(), Hello.class);
        if (sessionId == null || sessionId.isEmpty()) {
            sendIdentify();
        } else {
            timer.cancel();
            sendResumed();
        }
        startHeartbeatTimer(hello.getHeartbeatInterval());
    }

    // OP 11
    public void onHeartbeatACK() {
        log.debug("已收到服务端心跳.");
    }

    public void onClientClose(int code, String reason, boolean remote) {
        log.debug("连接关闭: {} {}[{}]", code, reason, remote);
        log.info("连接关闭!");
        log.info("5秒后开始尝试恢复连接...");
        try {
            Thread.sleep(5000);
            new Thread(() -> reConnect(code)).start();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("重新连接失败,请检查网络!");
        }
    }

    private void startHeartbeatTimer(Integer i) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Payload payload = new Payload();
                payload.setOp(1);
                payload.setD(client.getSeq());
                if (client.getReadyState() == ReadyState.OPEN) {
                    client.send(JSONUtil.toJsonStr(payload));
                }
            }
        }, i, i);
    }

    private void reConnect(Integer code) {
        log.info("正在重新连接...");
        client.reconnect();
        if (code != 4009) {
            sessionId = null;
        }
    }

    private void sendIdentify() {
        int intentsNum = 0;
        for (Intent intent : client.getIntents()) {
            intentsNum = intentsNum | intent.getValue();
        }
        Identify identify = new Identify();
        identify.setToken(client.getToken());
        identify.setIntents(intentsNum);
        Payload identifyPayload = new Payload();
        identifyPayload.setOp(2);
        identifyPayload.setD(identify);
        client.send(JSONUtil.toJsonStr(identifyPayload));
    }

    private void sendResumed() {
        JSONObject data = new JSONObject();
        data.set("token", client.getToken());
        data.set("session_id", sessionId);
        data.set("seq", client.getSeq());
        Payload payload = new Payload();
        payload.setOp(6);
        payload.setD(data);
        client.send(JSONUtil.toJsonStr(payload));
    }
}
