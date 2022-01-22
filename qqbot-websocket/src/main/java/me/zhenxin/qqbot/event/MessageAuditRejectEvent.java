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

package me.zhenxin.qqbot.event;

import lombok.Getter;
import me.zhenxin.qqbot.entity.MessageAudited;

import java.util.EventObject;

/**
 * 消息审核不通过事件
 *
 * @author 真心
 * @since 2022/1/22 10:51
 */
@Getter
public class MessageAuditRejectEvent extends EventObject {
    private final MessageAudited audited;

    public MessageAuditRejectEvent(Object source, MessageAudited audited) {
        super(source);
        this.audited = audited;
    }
}
