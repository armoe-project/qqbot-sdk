/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
 * Copyright (C) 2022 xiaoye-bot Project Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.zhenxin.qqbot.entity;

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
