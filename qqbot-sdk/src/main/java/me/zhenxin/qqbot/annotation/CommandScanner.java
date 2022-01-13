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

package me.zhenxin.qqbot.annotation;

import java.lang.reflect.Method;

/**
 * 命令扫描器
 *
 * @author 真心
 * @since 2021/12/30 15:24
 */
public class CommandScanner {

    public static void scan(Class<CommandHandler> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            boolean annotationPresent = method.isAnnotationPresent(Command.class);
            if (annotationPresent) {
                Command commandAnno = method.getAnnotation(Command.class);
                String command = commandAnno.value();
                boolean admin = commandAnno.admin();
            }
        }
    }
}
