/*
 * qq-official-bot-sdk - QQ Official Bot SDK For Java
 * Copyright (C) 2021-2022 xiaoye-bot Project Team
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
import com.alibaba.fastjson.JSONObject;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.*;
import me.zhenxin.qqbot.enums.Intent;
import me.zhenxin.qqbot.event.*;
import me.zhenxin.qqbot.websocket.entity.Hello;
import me.zhenxin.qqbot.websocket.entity.Identify;
import me.zhenxin.qqbot.websocket.entity.Payload;
import me.zhenxin.qqbot.websocket.entity.Ready;
import org.java_websocket.enums.ReadyState;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

/**
 * WebSocket 事件
 *
 * @author 真心
 * @since 2021/12/17 13:05
 */
@Slf4j
class Event {
    @Setter
    Client client;
    private Timer timer;
    private String sessionId;
    private User me;

    // OP 0
    public void onDispatch(Payload payload) {
        String e = payload.getT();
        switch (e) {
            case "READY":
                Ready ready = JSON.toJavaObject((JSONObject) payload.getD(), Ready.class);
                sessionId = ready.getSessionId();
                client.getEventHandler().setMe(ready.getUser());
                me = ready.getUser();
                log.info("鉴权成功, 机器人已上线!");
                break;
            case "GUILD_CREATE":
                Guild gc = JSON.toJavaObject((JSONObject) payload.getD(), Guild.class);
                log.info("新增频道: {}({})", gc.getName(), gc.getId());
                GuildCreateEvent guildCreateEvent = new GuildCreateEvent(this, gc);
                client.getEventHandler().onGuildCreate(guildCreateEvent);
                break;
            case "GUILD_UPDATE":
                Guild gu = JSON.toJavaObject((JSONObject) payload.getD(), Guild.class);
                log.info("频道信息变更: {}({})", gu.getName(), gu.getId());
                GuildUpdateEvent guildUpdateEvent = new GuildUpdateEvent(this, gu);
                client.getEventHandler().onGuildUpdate(guildUpdateEvent);
                break;
            case "GUILD_DELETE":
                Guild gd = JSON.toJavaObject((JSONObject) payload.getD(), Guild.class);
                log.info("退出频道: {}({})", gd.getName(), gd.getId());
                GuildDeleteEvent guildDeleteEvent = new GuildDeleteEvent(this, gd);
                client.getEventHandler().onGuildDelete(guildDeleteEvent);
                break;
            case "CHANNEL_CREATE":
                Channel cc = JSON.toJavaObject((JSONObject) payload.getD(), Channel.class);
                log.info("子频道创建: {}({})", cc.getName(), cc.getId());
                ChannelCreateEvent channelCreateEvent = new ChannelCreateEvent(this, cc);
                client.getEventHandler().onChannelCreate(channelCreateEvent);
                break;
            case "CHANNEL_UPDATE":
                Channel cu = JSON.toJavaObject((JSONObject) payload.getD(), Channel.class);
                log.info("子频道更新: {}({})", cu.getName(), cu.getId());
                ChannelUpdateEvent channelUpdateEvent = new ChannelUpdateEvent(this, cu);
                client.getEventHandler().onChannelUpdate(channelUpdateEvent);
                break;
            case "CHANNEL_DELETE":
                Channel cd = JSON.toJavaObject((JSONObject) payload.getD(), Channel.class);
                log.info("子频道删除: {}({})", cd.getName(), cd.getId());
                ChannelDeleteEvent channelDeleteEvent = new ChannelDeleteEvent(this, cd);
                client.getEventHandler().onChannelDelete(channelDeleteEvent);
                break;
            case "GUILD_MEMBER_ADD":
                Member ma = JSON.toJavaObject((JSONObject) payload.getD(), Member.class);
                log.info("频道用户增加: {}[{}]({})", ma.getUser().getUsername(), ma.getNick(), ma.getUser().getId());
                GuildMemberAddEvent guildMemberAddEvent = new GuildMemberAddEvent(this, ma);
                client.getEventHandler().onGuildMemberAdd(guildMemberAddEvent);
                break;
            case "GUILD_MEMBER_UPDATE":
                Member mu = JSON.toJavaObject((JSONObject) payload.getD(), Member.class);
                log.info("频道用户更新: {}[{}]({})", mu.getUser().getUsername(), mu.getNick(), mu.getUser().getId());
                GuildMemberUpdateEvent guildMemberUpdateEvent = new GuildMemberUpdateEvent(this, mu);
                client.getEventHandler().onGuildMemberUpdate(guildMemberUpdateEvent);
                break;
            case "GUILD_MEMBER_REMOVE":
                Member md = JSON.toJavaObject((JSONObject) payload.getD(), Member.class);
                log.info("频道用户删除: {}[{}]({})", md.getUser().getUsername(), md.getNick(), md.getUser().getId());
                GuildMemberRemoveEvent guildMemberRemoveEvent = new GuildMemberRemoveEvent(this, md);
                client.getEventHandler().onGuildMemberRemove(guildMemberRemoveEvent);
                break;
            case "MESSAGE_REACTION_ADD":
                MessageReaction ra = JSON.toJavaObject((JSONObject) payload.getD(), MessageReaction.class);
                log.info("表情添加: {}({})", JSON.toJSONString(ra.getTarget()), ra.getChannelId());
                MessageReactionAddEvent messageReactionAddEvent = new MessageReactionAddEvent(this, ra);
                client.getEventHandler().onMessageReactionAdd(messageReactionAddEvent);
                break;
            case "MESSAGE_REACTION_REMOVE":
                MessageReaction rr = JSON.toJavaObject((JSONObject) payload.getD(), MessageReaction.class);
                log.info("表情移除: {}({})", JSON.toJSONString(rr.getTarget()), rr.getChannelId());
                MessageReactionRemoveEvent messageReactionRemoveEvent = new MessageReactionRemoveEvent(this, rr);
                client.getEventHandler().onMessageReactionRemove(messageReactionRemoveEvent);
                break;
            case "AT_MESSAGE_CREATE":
                Message atMessage = JSON.toJavaObject((JSONObject) payload.getD(), Message.class);
                log.info(
                        "[AtMessage]: 频道({}) 子频道({}) {}({}): {}",
                        atMessage.getGuildId(),
                        atMessage.getChannelId(),
                        atMessage.getAuthor().getUsername(),
                        atMessage.getAuthor().getId(),
                        atMessage.getContent()
                );
                if (client.getEventHandler().isRemoveAt()) {
                    atMessage.setContent(atMessage.getContent().replaceAll("<@!" + me.getId() + "> ", ""));
                    atMessage.setContent(atMessage.getContent().replaceAll("<@!" + me.getId() + ">", ""));
                }
                AtMessageEvent atMessageEvent = new AtMessageEvent(this, atMessage);
                client.getEventHandler().onAtMessage(atMessageEvent);
                break;
            case "MESSAGE_CREATE":
                Message userMessage = JSON.toJavaObject((JSONObject) payload.getD(), Message.class);
                log.info(
                        "[UserMessage]: 频道({}) 子频道({}) {}({}): {}",
                        userMessage.getGuildId(),
                        userMessage.getChannelId(),
                        userMessage.getAuthor().getUsername(),
                        userMessage.getAuthor().getId(),
                        userMessage.getContent()
                );
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
    }

    // OP 10
    public void onHello(Payload payload) {
        Hello hello = JSON.toJavaObject((JSONObject) payload.getD(), Hello.class);
        if (sessionId == null || sessionId.isEmpty()) {
            log.info("正在发送鉴权...");
            sendIdentify();
        } else {
            log.info("正在发送恢复...");
            sendResumed();
        }
        if (timer != null) {
            timer.cancel();
        }
        startHeartbeatTimer(hello.getHeartbeatInterval());
    }

    // OP 11
    public void onHeartbeat() {
        log.debug("已收到服务端心跳.");
    }

    public void onClientClose(int code, String reason, boolean remote) {
        switch (code) {
            case 4001:
                log.warn("服务端关闭连接, 原因 {} {}({})", code, "无效的 opcode", reason);
                break;
            case 4002:
                log.warn("服务端关闭连接, 原因 {} {}({})", code, "无效的 payload", reason);
                break;
            case 4007:
                log.warn("服务端关闭连接, 原因 {} {}({})", code, "seq 错误", reason);
                break;
            case 4008:
                log.warn("服务端关闭连接, 原因 {} {}({})", code, "发送 payload 过快，请重新连接，并遵守连接后返回的频控信息", reason);
                break;
            case 4009:
                log.warn("服务端关闭连接, 原因 {} {}({})", code, "连接过期，请重连", reason);
                break;
            case 4010:
                log.error("服务端关闭连接, 原因 {} {}({})", code, "无效的 shard", reason);
                System.exit(code);
                break;
            case 4011:
                log.error("服务端关闭连接, 原因 {} {}({})", code, "连接需要处理的频道过多，请进行合理的分片", reason);
                System.exit(code);
                break;
            case 4012:
                log.error("服务端关闭连接, 原因 {} {}({})", code, "无效的 version", reason);
                System.exit(code);
                break;
            case 4013:
                log.error("服务端关闭连接, 原因 {} {}({})", code, "无效的 intent", reason);
                System.exit(code);
                break;
            case 4014:
                log.error("服务端关闭连接, 原因 {} {}({})", code, "intent 无权限", reason);
                System.exit(code);
                break;
            case 4914:
                log.error("服务端关闭连接, 原因 {} {}({})", code, "机器人已下架,只允许连接沙箱环境,请断开连接,检验当前连接环境", reason);
                System.exit(code);
                break;
            case 4915:
                log.error("服务端关闭连接, 原因 {} {}({})", code, "机器人已封禁,不允许连接,请断开连接,申请解封后再连接", reason);
                System.exit(code);
                break;
            default:
                sessionId = null;
                if (remote) {
                    log.warn("服务端关闭连接, 原因 {} {}", code, reason);
                } else {
                    log.warn("客户端关闭连接, 原因 {} {}", code, reason);
                }
        }

        log.info("5秒后开始尝试恢复连接...");
        try {
            Thread.sleep(5000);
            new Thread(() -> reconnect(code)).start();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("重新连接失败,请检查网络!");
        }
    }

    private void startHeartbeatTimer(Integer i) {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (client.getReadyState() == ReadyState.OPEN) {
                    Payload payload = new Payload();
                    payload.setOp(1);
                    payload.setD(client.getSeq());
                    log.debug("向服务端发送心跳.");
                    client.send(JSON.toJSONString(payload));
                }
            }
        };
        timer.schedule(task, i, i);
    }

    private void reconnect(Integer code) {
        log.info("正在重新连接...");
        if (code != 4009) {
            sessionId = null;
        }
        client.reconnect();
    }

    private void sendIdentify() {
        Identify identify = new Identify();
        Integer shard = client.getShard();
        Integer totalShard = client.getTotalShard();
        if (shard != null && totalShard != null) {
            identify.setShard(Arrays.asList(shard, totalShard));
        }
        int intentsNum = 0;
        for (Intent intent : client.getIntents()) {
            intentsNum = intentsNum | intent.getValue();
        }
        identify.setToken(client.getToken());
        identify.setIntents(intentsNum);
        Payload identifyPayload = new Payload();
        identifyPayload.setOp(2);
        identifyPayload.setD(identify);
        client.send(JSON.toJSONString(identifyPayload));
    }

    private void sendResumed() {
        JSONObject data = new JSONObject();
        data.put("token", client.getToken());
        data.put("session_id", sessionId);
        data.put("seq", client.getSeq());
        Payload payload = new Payload();
        payload.setOp(6);
        payload.setD(data);
        client.send(JSON.toJSONString(payload));
    }
}
