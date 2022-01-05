# qq-official-bot-sdk

QQ官方机器人 SDK For Java

[![Maven metadata URL](https://img.shields.io/maven-central/v/me.zhenxin/qqbot-parent)](https://search.maven.org/artifact/me.zhenxin/qqbot-sdk)
![GitHub Repo stars](https://img.shields.io/github/stars/xiaoye-bot/qq-official-bot-sdk)

* [加入QQ频道](https://qun.qq.com/qqweb/qunpro/share?_wv=3&_wwv=128&inviteCode=GECpm&from=246610&biz=ka)
* [使用文档](https://sdk.armoe.cn/qq/)

## 警告

请勿使用`0.0.2-SNAPSHOT`版本的SDK!

此版本存在`Log4j 2 远程代码执行漏洞`

详细情况请参考: [腾讯云公告](https://cloud.tencent.com/announce/detail/1692)

另 `0.0.3-SNAPSHOT - 0.0.8-SNAPSHOT` 存在另一漏洞 不建议使用

另 `0.0.9-SNAPSHOT, 0.0.10-SNAPSHOT` 存在另一漏洞 不建议使用

## 使用

1.添加依赖

* Maven

```xml

<dependency>
    <groupId>me.zhenxin</groupId>
    <artifactId>qqbot-sdk</artifactId>
    <version>${version}</version>
</dependency>
```

* Gradle Kotlin DSL

```kotlin

implementation("me.zhenxin:qqbot-sdk:${version}")
```

* Gradle Groovy DSL

```groovy

implementation 'me.zhenxin:qqbot-sdk:${version}'
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
        // 注册AT消息相关事件
        bot.registerAtMessageEvent();
        // 设置事件处理器
        IEventHandler handler = new IEventHandler();
        // handler.setRemoveAt(false); // 取消删除消息中的艾特
        bot.setEventHandler(handler);
        // 启动
        bot.start();
    }
}

// 自定义事件处理器 继承EventHandler
@Slf4j
@AllArgsConstructor
class IEventHandler extends EventHandler {
    private final ApiManager api;

    // 处理错误
    @Override
    public void onError(Throwable t) {
        log.error("发生错误: {}", t.getMessage());
    }

    @Override
    public void onAtMessage(AtMessageEvent event) {
        Message message = event.getMessage();
        String guildId = message.getGuildId();
        String channelId = message.getChannelId();
        String content = message.getContent();
        String messageId = message.getId();
        User author = message.getAuthor();
        try {
            String[] args = content.split(" ");
            String command = args[0];
            switch (command) {
                case "ping":
                    api.getMessageApi()
                            .sendMessage(channelId, "pong", messageId);
                    break;
            }
        } catch (ApiException e) {
            log.error("消息处理发生异常: {} {}({})", e.getCode(), e.getMessage(), e.getError());
            api.getMessageApi().sendMessage(channelId, "消息处理失败: " + e.getMessage(), messageId);
        }
    }
}
```

## 单独使用API

```xml

<dependency>
    <groupId>me.zhenxin</groupId>
    <artifactId>qqbot-api</artifactId>
    <version>${version}</version>
</dependency>
```

```java

@Slf4j
class Example {
    public static void main(String[] args) {
        AccessInfo accessInfo = new AccessInfo();
        accessInfo.setBotAppId(0); // 管理端的BotAppId
        accessInfo.setBotToken(""); // 管理端的BotToken
        // 使用沙盒模式
        accessInfo.useSandBoxMode();
        // 创建实例
        ApiManager api = new ApiManager(accessInfo);
        // 调用
        List<Guild> guilds = api.getUserApi().getMeGuilds();

        log.info("{}", guilds);
    }
}
```

## 自定义日志级别

添加环境变量 `LogLevel` 设置日志级别

| 等级    | 描述               |
|-------|------------------|
| INFO  | 信息 对应log.info()  |
| DEBUG | 调试 对应log.debug() |
| WARN  | 警告 对应log.warn()  |
| ERROR | 错误 对应log.error() |

## 模块说明

| 模块              | 说明          |
|-----------------|-------------|
| qqbot-common    | 公共文件 实体类等   |
| qqbot-api       | API实现 可单独使用 |
| qqbot-websocket | Ws实现        |
| qqbot-sdk       | SDK集成       |
