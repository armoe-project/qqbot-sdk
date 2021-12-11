package me.zhenxin.qqbot.core;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.Identify;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.Payload;
import me.zhenxin.qqbot.entity.Ready;
import me.zhenxin.qqbot.enums.Intent;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.List;
import java.util.Timer;

/**
 * WebSocket 客户端
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/11 20:21
 */
@Slf4j
class WSClient extends WebSocketClient {
    @Setter
    private String token;
    @Setter
    private List<Intent> intents;
    @Setter
    private EventHandler eventHandler;

    private Timer timer;
    private Integer seq;
    private String sessionId;

    public WSClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        log.info("连接成功!");
    }

    @Override
    public void onMessage(String message) {
        log.debug("收到消息: " + message);
        Payload payload = JSONUtil.toBean(message, Payload.class);
        if (payload.getS() != null) seq = payload.getS();
        switch (payload.getOp()) {
            case 7:
                close();
                break;
            case 9:
                log.error("鉴权失败!");
                System.exit(1);
                break;
            case 10:
                if (sessionId == null || sessionId.isEmpty()) {
                    int intentsNum = 0;
                    for (Intent intent : intents) {
                        intentsNum = intentsNum | intent.getValue();
                    }
                    Identify identify = new Identify();
                    identify.setToken(token);
                    identify.setIntents(intentsNum);
                    Payload identifyPayload = new Payload();
                    identifyPayload.setOp(2);
                    identifyPayload.setD(identify);
                    send(JSONUtil.toJsonStr(identifyPayload));
                }
                break;
            case 11:
                log.debug("已收到服务端心跳.");
                break;
            case 0:
                String e = payload.getT();
                switch (e) {
                    case "READY":
                        Ready ready = JSONUtil.toBean((JSONObject) payload.getD(), Ready.class);
                        sessionId = ready.getSessionId();
                        startHeartbeatTimer();
                        break;
                    case "AT_MESSAGE_CREATE":
                        Message atMessage = JSONUtil.toBean((JSONObject) payload.getD(), Message.class);
                        AtMessageEvent atMessageEvent = new AtMessageEvent(this, atMessage);
                        eventHandler.onAtMessage(atMessageEvent);
                        break;
                    case "MESSAGE_CREATE":
                        Message userMessage = JSONUtil.toBean((JSONObject) payload.getD(), Message.class);
                        UserMessageEvent userMessageEvent = new UserMessageEvent(this, userMessage);
                        eventHandler.onUserMessage(userMessageEvent);
                        break;
                    case "RESUMED":
                        log.info("恢复连接成功, 离线消息已处理!");
                    default:
                        log.warn("未知事件: " + e);
                }
                break;
            default:
                log.warn("未知消息类型: OpCode " + payload.getOp());
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("连接关闭!");
        log.info("2秒后开始尝试恢复连接...");
        try {
            Thread.sleep(2000);
            new Thread(this::reConnect).start();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("重新连接失败,请检查网络!");
        }
    }

    @Override
    public void onError(Exception ex) {
        log.info("发生错误: " + ex.getMessage());
        ex.printStackTrace();
    }

    @Override
    public void send(String text) {
        log.debug("发送消息: " + text);
        super.send(text);
    }

    @Override
    public void send(byte[] data) {
        log.debug("发送消息: " + new String(data));
        super.send(data);
    }

    public void sendHeartbeat() {
        Payload payload = new Payload();
        payload.setOp(1);
        payload.setD(seq);
        if (getReadyState() == ReadyState.OPEN) {
            send(JSONUtil.toJsonStr(payload));
        }
    }

    public void startHeartbeatTimer() {
        timer = new Timer();
        timer.schedule(new HeartbeatTimer(this), 0, 15000);
    }

    public void reConnect() {
        log.info("正在重新连接...");
        reconnect();
        while (true) {
            if (getReadyState() == ReadyState.OPEN) {
                JSONObject data = new JSONObject();
                data.set("token", token);
                data.set("session_id", sessionId);
                data.set("seq", seq);
                Payload payload = new Payload();
                payload.setOp(6);
                payload.setD(data);
                send(JSONUtil.toJsonStr(payload));
                break;
            }
        }
    }
}
