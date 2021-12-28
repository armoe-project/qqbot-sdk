# qq-official-bot-sdk

QQ官方机器人 SDK For Java

![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=http%3A%2F%2Frepo.zhenxin.me%2Fme%2Fzhenxin%2Fqq-official-bot-sdk%2Fmaven-metadata.xml)
![GitHub Repo stars](https://img.shields.io/github/stars/xiaoye-bot/qq-official-bot-sdk)

* [加入QQ频道](https://qun.qq.com/qqweb/qunpro/share?_wv=3&_wwv=128&inviteCode=GECpm&from=246610&biz=ka)
* [使用文档](https://sdk.armoe.cn/qq/)

## 警告

请勿使用`0.0.2-SNAPSHOT`版本的SDK!

此版本存在`Log4j 2 远程代码执行漏洞`

另 `0.0.3-SNAPSHOT - 0.0.8-SNAPSHOT` 存在另一漏洞 不建议使用

详细情况请参考: [腾讯云公告](https://cloud.tencent.com/announce/detail/1692)

## 使用

1.添加依赖

* Maven

```xml

<repository>
    <id>zhenxin</id>
    <url>https://repo.zhenxin.me/</url>
</repository>
```

```xml

<dependency>
    <groupId>me.zhenxin</groupId>
    <artifactId>qq-official-bot-sdk</artifactId>
    <version>${version}</version>
</dependency>
```

* Gradle Kotlin DSL

```kotlin
repositories {
    maven("https://repo.zhenxin.me/")
}

dependencies {
    implementation("me.zhenxin:qq-official-bot-sdk:${version}")
}
```

* Gradle Groovy DSL

```groovy
repositories {
    maven {
        url 'https://repo.zhenxin.me/'
    }
}

dependencies {
    implementation 'me.zhenxin:qq-official-bot-sdk:${version}'
}
```

2.使用

```java
class Example {
    public static void main(String[] args) {
        AccessInfo accessInfo = new AccessInfo();
        accessInfo.setBotAppId(0); // 管理端的BotAppId
        accessInfo.setBotToken(""); // 管理端的BotToken
        // 使用沙盒模式
        accessInfo.useSandBoxMode();
        // 创建实例
        BotCore bot = new BotCore(accessInfo);
        // 获取API管理器
        ApiManager api = bot.getApiManager();
        // 注册事件订阅
        bot.registerIntents(
                Intent.AT_MESSAGES // AT消息相关事件
        );
        // 设置事件处理器
        bot.setEventHandler(new IEventHandler(api));
        // 启动
        bot.start();
    }
}

// 自定义事件处理器 继承EventHandler
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
```
