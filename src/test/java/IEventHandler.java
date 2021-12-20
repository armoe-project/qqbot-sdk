import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.core.ApiManager;
import me.zhenxin.qqbot.core.EventHandler;
import me.zhenxin.qqbot.entity.AudioControl;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.MessageReaction;
import me.zhenxin.qqbot.entity.User;
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.event.GuildUpdateEvent;
import me.zhenxin.qqbot.event.MessageReactionAddEvent;
import me.zhenxin.qqbot.event.MessageReactionRemoveEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;
import me.zhenxin.qqbot.exception.ApiException;
import me.zhenxin.qqbot.template.TextThumbnailTemplate;

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
    public void onUserMessage(UserMessageEvent event) {
        Message message = event.getMessage();
        log.info(message.toString());
        String guildId = message.getGuildId();
        String channelId = message.getChannelId();
        String content = message.getContent();
        String messageId = message.getId();
        User author = message.getAuthor();
        try {
            String[] args = content.split(" ");
            String command = args[0];
            switch (command) {
                case "info":
                    AudioControl control = new AudioControl();
                    control.setStatus(0);
                    control.setText("测试");
                    control.setAudioUrl("http://m7.music.126.net/20211219162118/d9b0454e49ddd50ceabe41a269242ba8/ymusic/515c/005d/545e/f6aa38a76977062514bcc4b7371bd57c.mp3");
                    api.getAudioApi().AudioControl("2069055", control);

                    break;
                case "ping":
                    api.getMessageApi().sendMessage(channelId, "pong", messageId);
                    break;
                case "ark":
                    MessageArk ark = TextThumbnailTemplate.builder()
                            .build().toMessageArk();
                    api.getMessageApi().sendMessage(channelId, ark, messageId);
                    break;
            }
        } catch (ApiException e) {
            log.error("消息处理发生异常: {} {}({})", e.getCode(), e.getMessage(), e.getError());
            api.getMessageApi().sendMessage(channelId, "消息处理失败: " + e.getMessage(), messageId);
        }
    }

    @Override
    public void onGuildUpdate(GuildUpdateEvent event) {
        log.info("{}", event.getGuild().toString());
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        MessageReaction reaction = event.getReaction();
        api.getMessageApi().sendMessage(
                reaction.getChannelId(),
                reaction.toString(),
                null
        );
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        MessageReaction reaction = event.getReaction();
        api.getMessageApi().sendMessage(
                reaction.getChannelId(),
                reaction.toString(),
                null
        );
    }
}
