/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
 * Copyright (C) 2022 xiaoye-bot Project Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.zhenxin.qqbot.websocket;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.enums.Intent;
import me.zhenxin.qqbot.websocket.entity.Payload;
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
public class Client extends WebSocketClient {
    private final Event event;
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

    @Getter
    private Integer shard;
    @Getter
    private Integer totalShard;

    public Client(URI uri) {
        super(uri);
        event = new Event();
        event.setClient(this);
    }

    public void setShard(Integer shard, Integer totalShard) {
        this.shard = shard;
        this.totalShard = totalShard;
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        Thread.currentThread().setName("WebSocket");
        log.info("已连接至网关!");
    }

    @Override
    public void onMessage(String message) {
        log.debug("收到消息: " + message);
        Payload payload = JSON.parseObject(message, Payload.class);
        if (payload.getS() != null) {
            seq = payload.getS();
        }
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
                event.onHeartbeat();
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
        eventHandler.onError(ex);
    }

    @Override
    public void send(String text) {
        super.send(text);
        log.debug("发送消息: " + text);
    }
}
