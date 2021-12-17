package me.zhenxin.qqbot.core;

import cn.hutool.json.JSONUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.ws.Payload;
import me.zhenxin.qqbot.enums.Intent;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.List;

/**
 * WebSocket 客户端
 *
 * @author 真心
 * @since 2021/12/11 20:21
 */
@Slf4j
class WSClient extends WebSocketClient {
    private final WSEvent event;
    @Setter
    @Getter
    private String token;
    @Setter
    @Getter
    private List<Intent> intents;
    @Setter
    @Getter
    private EventHandler eventHandler;
    @Getter
    private Integer seq;

    public WSClient(URI serverUri) {
        super(serverUri);
        event = new WSEvent();
        event.setClient(this);
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
            case 0:
                event.onDispatch(payload);
                break;
            case 7:
                event.onReconnect();
                break;
            case 9:
                event.onInvalidSession();
                break;
            case 10:
                event.onHello(payload);
                break;
            case 11:
                event.onHeartbeatACK();
                break;
            default:
                log.warn("未知消息类型: OpCode " + payload.getOp());
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        event.onClientClose(code, reason, remote);
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

}
