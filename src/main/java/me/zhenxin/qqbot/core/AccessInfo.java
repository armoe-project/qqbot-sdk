package me.zhenxin.qqbot.core;

import lombok.Data;

/**
 * 访问信息
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/9 0:32
 */
@Data
public class AccessInfo {
    /**
     * 管理端的 BotAppID
     */
    private Integer botAppId;
    /**
     * 管理端的 BotToken
     */
    private String botToken;
    /**
     * 管理端的 BotSecret
     */
    private String botSecret;
    /**
     * 是否使用沙盒模式
     */
    private Boolean useSandBoxMode = false;
}
