import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.core.ApiManager;
import me.zhenxin.qqbot.core.EventHandler;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.User;
import me.zhenxin.qqbot.event.UserMessageEvent;

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
    public void onUserMessage(UserMessageEvent event) {
        super.onUserMessage(event);
        Message message = event.getMessage();
        String guildId = message.getGuildId();
        String channelId = message.getChannelId();
        String content = message.getContent();
        String messageId = message.getId();
        User author = message.getAuthor();

        if (content.contains("ping")) {
            api.getMessageApi().sendTextAndImageMessage(channelId,"内容。", "https://tva1.sinaimg.cn/large/0072Vf1pgy1foxkd13vc7j31kw0w0txx.jpg", messageId);
        }
    }
}
