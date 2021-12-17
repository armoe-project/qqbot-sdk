package me.zhenxin.qqbot.template;

import lombok.Data;

/**
 * 文本+链接模板 #LIST# 对象
 *
 * @author 真心
 * @since 2021/12/9 22:49
 */
@Data
public class LinkText {
    /**
     * 文本内容
     */
    private String desc;
    /**
     * 链接
     */
    private String link;

}
