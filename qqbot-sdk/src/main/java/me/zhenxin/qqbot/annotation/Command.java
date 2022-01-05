package me.zhenxin.qqbot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 真心
 * @since 2021/12/30 14:46
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {
    /**
     * 命令名称
     */
    String value();

    /**
     * 命令描述
     */
    String description() default "";

    /**
     * 是否需要管理员权限
     */
    boolean admin() default false;
}
