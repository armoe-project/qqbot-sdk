package me.zhenxin.qqbot.entity.keyboard;

import lombok.Data;

/**
 * 按钮操作对象
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2022/9/24 10:22
 */
@Data
public class Action {
    /**
     * 操作类型
     * <ul>
     *     <li>0: http 或 小程序 客户端识别 schem, data字段为链接</li>
     *     <li>1: 回调后台接口, data 传给后台</li>
     *     <li>at机器人, 根据 at_bot_show_channel_list 决定在当前频道或用户选择频道,自动在输入框 @bot data</li>
     * </ul>
     */
    private Integer type;
    /**
     * 用于设定操作按钮所需的权限
     */
    private Permission permission;
    /**
     * 可点击的次数, 默认不限
     */
    private Integer clickLimit;
    /**
     * 操作相关数据
     */
    private String data;
    /**
     * AT机器人是否弹出子频道选择器
     */
    private Boolean atBotShowChannelList;
}
