package me.zhenxin.qqbot.core;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;
import me.zhenxin.qqbot.pojo.Identify;
import me.zhenxin.qqbot.pojo.Message;
import me.zhenxin.qqbot.pojo.Payload;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/**
 * WebSocket 客户端
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 1:23
 */
@Setter
@Slf4j
class WSSClient {
    private URI uri;
    private String token;
    private List<Intent> intents;
    private EventHandler eventHandler;

    private Integer seq;
    private WebSocketClient client;

    public WSSClient(URI uri, String token, List<Intent> intents, EventHandler eventHandler) {
        this.uri = uri;
        this.token = token;
        this.intents = intents;
        this.eventHandler = eventHandler;
    }

    public void connect() {
        client = new WebSocketClient(uri) {

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                log.info("连接成功!");
            }

            @Override
            public void onMessage(String s) {
                Payload payload = JSONUtil.toBean(s, Payload.class);
                log.debug(JSONUtil.toJsonStr(payload));
                seq = payload.getS();
                switch (payload.getOp()) {
                    case 7:
                        close();
                        break;
                    case 10:
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
                        break;
                    case 0:
                        String e = payload.getT();
                        switch (e) {
                            case "READY":
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
                        }
                        break;
                }
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                log.info("连接关闭!");
                log.info("开始尝试重新连接...");
                try {
                    new Thread(this::connect).start();
                } catch (Exception e) {
                    e.printStackTrace();
                    log.info("重新连接失败,请检查网络!");
                }
            }

            @Override
            public void onError(Exception e) {
                log.info("发生错误: " + e.getMessage());
                e.printStackTrace();
            }
        };
        client.setConnectionLostTimeout(0);
        client.connect();
    }

    public void startHeartbeatTimer() {
        Timer timer = new Timer();
        timer.schedule(new HeartbeatTimer(this), 0, 15000);
    }

    public void sendHeartbeat() {
        Map<String, Integer> data = new HashMap<>();
        data.put("op", 1);
        data.put("d", seq);
        client.send(JSONUtil.toJsonStr(data));
    }

    public void reconnect() {
        connect();
    }
}
