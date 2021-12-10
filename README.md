# qq-official-bot-sdk

QQ官方机器人 SDK For Java

* [加入QQ频道](https://qun.qq.com/qqweb/qunpro/share?_wv=3&_wwv=128&inviteCode=GECpm&from=246610&biz=ka)
* 使用文档(编写中)

## 警告

请勿使用`0.0.2-SNAPSHOT`版本的SDK!

此版本存在`Log4j 2 远程代码执行漏洞`

详情情况请参考: https://cloud.tencent.com/announce/detail/1692

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
    <version>0.0.4-SNAPSHOT</version>
</dependency>
```

* Gradle Kotlin DSL

```kotlin
repositories {
    maven("https://repo.zhenxin.me/")
}

dependencies {
    implementation("me.zhenxin:qq-official-bot-sdk:0.0.4-SNAPSHOT")
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
    implementation 'me.zhenxin:qq-official-bot-sdk:0.0.4-SNAPSHOT'
}
```

2.使用

```java
import me.zhenxin.qqbot.core.AccessInfo;
import me.zhenxin.qqbot.core.ApiManager;
import me.zhenxin.qqbot.core.BotCore;
import me.zhenxin.qqbot.core.EventHandler;
import me.zhenxin.qqbot.event.AtMessageEvent;
import me.zhenxin.qqbot.pojo.Message;
import me.zhenxin.qqbot.pojo.ark.MessageArk;
import me.zhenxin.qqbot.template.TextThumbnailTemplate;

class Example {
    public static void main(String[] args) {
        AccessInfo accessInfo = new AccessInfo();
        accessInfo.setBotAppId(0); // 管理端的BotAppId
        accessInfo.setBotToken(""); // 管理端的BotToken
        accessInfo.setUseSandBoxMode(true); // 使用沙盒模式
        // 创建实例
        BotCore bot = new BotCore(accessInfo);
        // 获取API管理器
        ApiManager api = bot.getApiManager();
        // 注册AT消息相关事件
        bot.registerAtMessageEvent();
        // 设置事件处理器
        bot.setEventHandler(new IEventHandler(api));
        // 启动
        bot.start();
    }
}

// 自定义事件处理器 继承EventHandler
class IEventHandler extends EventHandler {
    private final ApiManager api;

    public IEventHandler(ApiManager api) {
        this.api = api;
    }

    @Override
    public void onAtMessage(AtMessageEvent event) {
        Message message = event.getMessage();
        String channelId = message.getChannelId();
        String content = message.getContent();
        String messageId = message.getId();

        if (content.contains("ping")) {
            // 文本消息
            api.getMessageApi()
                    .sendTextMessage(channelId, "pong!", messageId);
        } else if (content.contains("ark")) {
            // 模板消息
            MessageArk ark = TextThumbnailTemplate.builder()
                    .build()
                    .toMessageArk();
            api.getMessageApi()
                    .sendTemplateMessage(channelId, ark, messageId);
        }
    }
}

```