import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.api.ApiManager;
import me.zhenxin.qqbot.entity.Member;
import me.zhenxin.qqbot.entity.Message;
import me.zhenxin.qqbot.entity.MessageEmbed;
import me.zhenxin.qqbot.entity.User;
import me.zhenxin.qqbot.entity.ark.MessageArk;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.event.UserMessageEvent;
import me.zhenxin.qqbot.exception.ApiException;
import me.zhenxin.qqbot.template.EmbedTemplate;
import me.zhenxin.qqbot.template.TextThumbnailTemplate;
import me.zhenxin.qqbot.websocket.EventHandler;

import java.util.ArrayList;
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
        Message message = event.getMessage();
        message(message);
    }

    @Override
    protected void onAtMessage(AtMessageEvent event) {
        Message message = event.getMessage();
        message(message);
    }

    private void message(Message message) {
        String guildId = message.getGuildId();
        String channelId = message.getChannelId();
        String content = message.getContent();
        String messageId = message.getId();
        User author = message.getAuthor();
        try {
            String[] args = content.split(" ");
            String command = args[0];
            switch (command) {
                case "error":
                    api.getMessageApi().sendMessage(
                            channelId,
                            "https://www.qq.com",
                            messageId
                    );
                case "members":
                    List<Member> members = api.getGuildApi().getGuildMembers(guildId, 1000);
                    for (Member member : members) {
                        member.getUser().setAvatar("");
                    }
                    api.getMessageApi().sendMessage(
                            channelId,
                            members.toString(),
                            messageId
                    );
                    break;
                case "info":
                    api.getChannelPermissionsApi().addChannelPermissions(channelId, author.getId(), 1);
                    break;
                case "muteAll":
                    api.getMuteApi().muteAll(guildId, 300);
                    break;
                case "muteMe":
                    api.getMuteApi().mute(guildId, author.getId(), 300);
                    Thread.sleep(6000);
                    api.getMuteApi().mute(guildId, author.getId(), 0);
                    break;
                case "dMsg":
                    Message m = api.getMessageApi().sendMessage(channelId, "你好", messageId);
                    String id = m.getId();
                    api.getMessageApi().deleteMessage(channelId, id);
                    break;
                case "embed":
                    List<String> fields = new ArrayList<>();
                    fields.add("测试");
                    fields.add("测试2");
                    fields.add(String.valueOf(System.currentTimeMillis()));
                    MessageEmbed embed = EmbedTemplate.builder()
                            .title("测试")
                            .prompt("[测试]Embed")
                            .thumbnail("https://b.armoe.cn/assets/image/logo.png")
                            .fields(fields)
                            .build().toMessageEmbed();
                    api.getMessageApi().sendMessage(channelId, embed, messageId);
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
