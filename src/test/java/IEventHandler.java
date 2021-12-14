import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.core.ApiManager;
import me.zhenxin.qqbot.core.EventHandler;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.User;
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.exception.ApiException;
import me.zhenxin.qqbot.template.TextThumbnailTemplate;

/**
 * 事件执行器
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/11 21:28
 */
@Slf4j
class IEventHandler extends EventHandler {
    private final ApiManager api;

    public IEventHandler(ApiManager api) {
        this.api = api;
    }

    @Override
    public void onAtMessage(AtMessageEvent event) {
        Message message = event.getMessage();
        String guildId = message.getGuildId();
        String channelId = message.getChannelId();
        String content = message.getContent();
        String messageId = message.getId();
        User author = message.getAuthor();
        super.onAtMessage(event);
        try {
            if (content.contains("ping")) {
                log.info("pong!");
                MessageArk ark = TextThumbnailTemplate.builder().build().toMessageArk();
                api.getMessageApi().sendTemplateMessage(channelId, ark, messageId);
            }
        } catch (ApiException e) {
            log.warn("消息处理发生异常: {}-{} {}", e.getCode(), e.getMessage(), e.getError());
            api.getMessageApi().sendTextMessage(channelId, "消息处理失败: " + e.getMessage(), messageId);
        }
    }
}
