import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
class IEventHandler extends EventHandler {
    private final ApiManager api;

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
            String[] args = content.split(" ");
            String command = args[0];
            switch (command) {
                case "info":
                    api.getMessageApi()
                            .sendTextMessage(channelId, JSONUtil.toJsonStr(message), messageId);
                    break;
                case "ping":
                    api.getMessageApi()
                            .sendTextMessage(channelId, "pong", messageId);
                    break;
                case "ark":
                    MessageArk ark = TextThumbnailTemplate.builder()
                            .build().toMessageArk();
                    api.getMessageApi()
                            .sendTemplateMessage(channelId, ark, messageId);
                    break;
            }
        } catch (ApiException e) {
            log.error("消息处理发生异常: {} {}({})", e.getCode(), e.getMessage(), e.getError());
            api.getMessageApi().sendTextMessage(channelId, "消息处理失败: " + e.getMessage(), messageId);
        }
    }
}