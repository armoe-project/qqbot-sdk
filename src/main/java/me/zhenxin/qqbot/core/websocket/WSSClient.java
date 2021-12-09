package me.zhenxin.qqbot.core.websocket;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Setter;
import me.zhenxin.qqbot.core.EventHandler;
import me.zhenxin.qqbot.core.Intent;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;
import me.zhenxin.qqbot.pojo.Identify;
import me.zhenxin.qqbot.pojo.Message;
import me.zhenxin.qqbot.pojo.Payload;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.*;

/**
 * WebSocket 客户端
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 1:23
 */
@Setter
public class WSSClient extends WebSocketClient {
    private String token;
    private List<Intent> intents;
    private Integer s;
    private EventHandler eventHandler;

    public WSSClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("连接成功!");
    }

    @Override
    public void onMessage(String s) {
        Payload payload = JSONUtil.toBean(s, Payload.class);
        if (Objects.equals(System.getenv("DEBUG"), "true")) {
            System.out.println(payload);
        }
        this.s = payload.getS();
        switch (payload.getOp()) {
            case 10:
                int intents = 0;
                for (Intent intent : this.intents) {
                    intents = intents | intent.getValue();
                }
                Identify identify = new Identify();
                identify.setToken(token);
                identify.setIntents(intents);
                Payload identifyPayload = new Payload();
                identifyPayload.setOp(2);
                identifyPayload.setD(identify);
                send(JSONUtil.toJsonStr(identifyPayload));
                break;
            case 0:
                String e = payload.getT();
                switch (e) {
                    case "READY":
                        Timer timer = new Timer();
                        timer.schedule(new HeartbeatTimer(this), 0, 15000);
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
        System.out.println("连接关闭!");
    }

    @Override
    public void onError(Exception e) {
        System.out.println("发生错误: " + e.getMessage());
        e.printStackTrace();
    }

    public void sendHeartbeat() {
        Map<String, Integer> data = new HashMap<>();
        data.put("op", 1);
        data.put("d", s);
        send(JSONUtil.toJsonStr(data));
    }
}
