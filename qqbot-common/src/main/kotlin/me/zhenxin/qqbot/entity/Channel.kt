/*
 * QQBot SDK - QQ Official Bot SDK
 * Copyright (C) 2023 ZhenXin
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

package me.zhenxin.qqbot.entity

import com.alibaba.fastjson2.annotation.JSONField
import me.zhenxin.qqbot.enums.ChannelSubType
import me.zhenxin.qqbot.enums.ChannelType
import me.zhenxin.qqbot.enums.PrivateType
import me.zhenxin.qqbot.enums.SpeakPermission

/**
 * 子频道
 *
 * @author 真心
 * @since 2023/10/23 10:23
 */
data class Channel(
    /**
     * 子频道 ID
     */
    var id: Long = 0,
    /**
     * 频道 ID
     */
    @JSONField(name = "guild_id")
    var guildId: Long = 0,
    /**
     * 名称
     */
    var name: String = "",
    /**
     * 子频道类型
     */
    var type: ChannelType = ChannelType.TEXT,
    /**
     * 子频道子类型
     */
    @JSONField(name = "sub_type")
    var subType: ChannelSubType = ChannelSubType.CHAT,
    /**
     * 排序
     */
    var position: Int = 0,
    /**
     * 所属分组 ID (在类型是分组时无效)
     */
    @JSONField(name = "parent_id")
    var parentId: String = "",
    /**
     * 创建人 ID
     */
    @JSONField(name = "owner_id")
    var ownerId: String = "",
    /**
     * 子频道私密类型
     */
    @JSONField(name = "private_type")
    var privateType: PrivateType = PrivateType.PUBLIC,
    /**
     * 子频道发言权限
     */
    @JSONField(name = "speak_permission")
    var speakPermission: SpeakPermission = SpeakPermission.ALL,
    /**
     * 子频道应用类型
     */
    @JSONField(name = "application_id")
    var applicationId: String = "",
    /**
     * 用户拥有的子频道权限
     */
    @JSONField(name = "permissions")
    var permissions: String = "",
)