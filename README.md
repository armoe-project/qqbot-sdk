<div align="center">

![][banner]

[![][maven-central]][maven-central-link] [![][license]](LICENSE)

</div>

## 使用

其中 `${version}` 为 [Maven Central][maven-central-link] 上的最新版本号。

### Gradle 项目

```groovy
implementation 'me.zhenxin:qqbot-sdk:${version}' // Groovy DSL
implementation("me.zhenxin:qqbot-sdk:${version}") // Kotlin DSL
```

### Maven 项目

```xml

<dependency>
    <groupId>me.zhenxin</groupId>
    <artifactId>qqbot-sdk</artifactId>
    <version>${version}</version>
</dependency>
```

## 日志级别

设置环境变量 `QQBOT_LOG_LEVEL` 来设置日志级别

| 日志级别    | 说明   |
|---------|------|
| `DEBUG` | 调试信息 |
| `INFO`  | 信息   |
| `WARN`  | 警告   |
| `ERROR` | 错误   |

## 开源协议

本项目使用 [GPL-3.0](LICENSE) 协议开放源代码

```text
QQBot SDK - QQ Official Bot SDK for Java/Kotlin
Copyright (C) 2023 ZhenXin
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
```

## 赞助

如果您觉得本项目对您有帮助，欢迎赞助我们

![][donate-image]

[banner]: https://socialify.git.ci/armoe-project/qqbot-sdk/image?description=1&forks=1&issues=1&language=1&name=1&owner=1&pulls=1&stargazers=1&theme=Auto

[maven-central]: https://img.shields.io/maven-central/v/me.zhenxin/qqbot-sdk?style=for-the-badge

[maven-central-link]: https://central.sonatype.com/artifact/me.zhenxin/qqbot-sdk

[license]: https://img.shields.io/github/license/armoe-project/qqbot-sdk?style=for-the-badge

[docs-link]: https://qqbot.armoe.cn

[qq-group-link]: https://qm.qq.com/q/yvYAnJEzsW

[donate-image]: https://s2.loli.net/2022/01/12/wqhXNKAlnMZ5oci.png
