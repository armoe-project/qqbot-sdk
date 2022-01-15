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

package me.zhenxin.qqbot.websocket.entity;

import lombok.Data;

/**
 * Gateway 类
 *
 * @author 真心
 * @since 2021/12/9 2:06
 */
@Data
public class Gateway {
    private Integer code;
    private String message;
    private String url;
    private Integer shards;
    private SessionStartLimit sessionStartLimit;

    @Data
    public static class SessionStartLimit {
        private Integer total;
        private Integer remaining;
        private Integer resetAfter;
        private Integer maxConcurrency;
    }
}
