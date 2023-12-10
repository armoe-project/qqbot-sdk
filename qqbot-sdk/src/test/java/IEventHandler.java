import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import me.zhenxin.qqbot.api.ApiManager;
import me.zhenxin.qqbot.entity.DirectMessageSession;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.MessageMarkdown;
import me.zhenxin.qqbot.entity.api.ApiPermission;
import me.zhenxin.qqbot.entity.api.ApiPermissionDemand;
import me.zhenxin.qqbot.entity.api.ApiPermissionDemandIdentify;
import me.zhenxin.qqbot.entity.forum.thread.Thread;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.DirectMessageEvent;
import me.zhenxin.qqbot.event.GroupMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;
import me.zhenxin.qqbot.exception.ApiException;
import me.zhenxin.qqbot.template.EmbedTemplate;
import me.zhenxin.qqbot.template.TextThumbnailTemplate;
import me.zhenxin.qqbot.websocket.EventHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 事件执行器
 *
 * @author 真心
 * @since 2021/12/11 21:28
 */
@Slf4j
@AllArgsConstructor
class IEventHandler extends EventHandler {
    private final ApiManager api;

    @Override
    protected void onUserMessage(UserMessageEvent event) {
        val message = event.getMessage();
        message(message);
    }

    @Override
    protected void onAtMessage(AtMessageEvent event) {
        val message = event.getMessage();
        message(message);
    }

    @Override
    protected void onDirectMessage(DirectMessageEvent event) {
        val message = event.getMessage();
        log.debug("{}", message);
        api.getDirectMessageApi().sendMessage(
                message.getGuildId(),
                "测试",
                message.getId()
        );
    }

    @Override
    protected void onGroupMessage(GroupMessageEvent event) {
        val message = event.getMessage();
        message(message);
    }

    private void message(Message message) {
        val guildId = message.getGuildId();
        val channelId = message.getChannelId();
        val groupId = message.getGroupId();
        val content = message.getContent();
        val messageId = message.getId();
        val author = message.getAuthor();
        try {
            if (content.contains("echo")) {
                api.getMessageApi()
                        .sendGroupMessage(groupId, content, messageId);
            }
        } catch (ApiException e) {
            log.error("消息处理发生异常: {} {}({})", e.getCode(), e.getMessage(), e.getError());
            api.getMessageApi().sendMessage(channelId, "消息处理失败: " + e.getMessage(), messageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
