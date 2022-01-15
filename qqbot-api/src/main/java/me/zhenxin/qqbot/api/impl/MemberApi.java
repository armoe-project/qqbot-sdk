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

package me.zhenxin.qqbot.api.impl;

import me.zhenxin.qqbot.api.BaseApi;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.entity.Member;
import me.zhenxin.qqbot.exception.ApiException;

/**
 * 成员相关接口
 *
 * @author 真心
 * @since 2021/12/11 13:11
 */
public class MemberApi extends BaseApi {
    public MemberApi(AccessInfo accessInfo) {
        super(accessInfo);
    }

    /**
     * 获取成员信息
     *
     * @param guildId 频道ID
     * @param userId  用户ID
     */
    public Member getMemberInfo(String guildId, String userId) throws ApiException {
        return get("/guilds/" + guildId + "/members/" + userId, Member.class);
    }

    /**
     * 删除频道成员 (仅私域可用)
     *
     * @param guildId 频道ID
     * @param userId  用户ID
     */
    public void deleteMember(String guildId, String userId) throws ApiException {
        delete("/guilds/" + guildId + "/members/" + userId, null);
    }
}
