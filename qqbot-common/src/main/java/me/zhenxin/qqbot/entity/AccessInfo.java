package me.zhenxin.qqbot.core;

import lombok.Data;

/**
 * 访问信息
 *
 * @author 真心
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
     * 是否使用沙箱模式
     */
    private Boolean useSandBoxMode = false;

    /**
     * 使用沙箱模式
     */
    public void useSandBoxMode() {
        this.useSandBoxMode = true;
    }

    /**
     * 设置沙箱模式
     *
     * @param useSandBoxMode 沙箱模式
     * @deprecated 使用 {@link #useSandBoxMode()} 替代
     */
    public void setUseSandBoxMode(Boolean useSandBoxMode) {
        this.useSandBoxMode = useSandBoxMode;
    }
}
