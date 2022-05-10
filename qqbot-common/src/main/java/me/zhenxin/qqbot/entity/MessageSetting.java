/*
 * qq-official-bot-sdk - QQ Official Bot SDK For Java
 * Copyright (C) 2021-2022 xiaoye-bot Project Team
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
 * 消息频率对象
 *
 * @author 真心
 * @since 2022/5/11 2:42
 */
@Data
public class MessageSetting {
    /**
     * 是否允许创建私信
     */
    private boolean disableCreateDm;
    /**
     * 是否允许发送主动消息
     */
    private boolean disablePushMsg;
    /**
     * 子频道列表
     */
    private String[] channelIds;
    /**
     * 每个子频道允许推送的最大数量
     */
    private Integer channelPushMaxNum;
}
