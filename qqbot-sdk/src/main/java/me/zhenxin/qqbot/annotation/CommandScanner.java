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
