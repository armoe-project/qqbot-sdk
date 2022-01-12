package me.zhenxin.qqbot.websocket;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.User;
import me.zhenxin.qqbot.event.*;

/**
 * 事件处理器
 *
 * @author 真心
 * @since 2021/12/9 12:19
 */
@SuppressWarnings("unused")
@Slf4j
public class EventHandler {
    /**
     * 机器人本身的用户信息
     */
    @Setter
    protected User me;
    /**
     * 是否去除消息中的@机器人
     */
    @Getter
    @Setter
    private boolean removeAt = true;

    /**
     * 错误处理
     *
     * @param e 异常
     */
    protected void onError(Exception e) {

    }

    /**
     * 频道新增
     *
     * @param event 事件
     */
    protected void onGuildCreate(GuildCreateEvent event) {

    }

    /**
     * 频道更新
     *
     * @param event 事件
     */
    protected void onGuildUpdate(GuildUpdateEvent event) {

    }

    /**
     * 频道删除
     *
     * @param event 事件
     */
    protected void onGuildDelete(GuildDeleteEvent event) {

    }

    /**
     * 子频道创建
     *
     * @param event 事件
     */
    protected void onChannelCreate(ChannelCreateEvent event) {

    }

    /**
     * 子频道更新
     *
     * @param event 事件
     */
    protected void onChannelUpdate(ChannelUpdateEvent event) {

    }

    /**
     * 子频道删除
     *
     * @param event 事件
     */
    protected void onChannelDelete(ChannelDeleteEvent event) {

    }

    /**
     * 频道成员增加
     *
     * @param event 事件
     */
    protected void onGuildMemberAdd(GuildMemberAddEvent event) {

    }

    /**
     * 频道成员更新
     *
     * @param event 事件
     */
    protected void onGuildMemberUpdate(GuildMemberUpdateEvent event) {

    }

    /**
     * 频道成员移除
     *
     * @param event 事件
     */
    protected void onGuildMemberRemove(GuildMemberRemoveEvent event) {

    }

    /**
     * 表态添加
     *
     * @param event 事件
     */
    protected void onMessageReactionAdd(MessageReactionAddEvent event) {

    }

    /**
     * 表态移除
     *
     * @param event 事件
     */
    protected void onMessageReactionRemove(MessageReactionRemoveEvent event) {

    }

    /**
     * 艾特信息
     *
     * @param event 事件
     */
    protected void onAtMessage(AtMessageEvent event) {

    }

    /**
     * 用户消息
     *
     * @param event 事件
     */
    protected void onUserMessage(UserMessageEvent event) {

    }
}
