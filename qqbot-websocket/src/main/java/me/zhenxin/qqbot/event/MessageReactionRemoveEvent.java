/*
 * qq-official-bot-sdk(qqbot) - QQ Official Bot SDK For Java
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
import me.zhenxin.qqbot.entity.MessageReaction;

import java.util.EventObject;

/**
 * 表态移除
 *
 * @author 真心
 * @since 2021/12/19 16:04
 */
@Getter
public class MessageReactionRemoveEvent extends EventObject {
    private final MessageReaction reaction;

    public MessageReactionRemoveEvent(Object source, MessageReaction reaction) {
        super(source);
        this.reaction = reaction;
    }
}
