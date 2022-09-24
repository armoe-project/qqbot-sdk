package me.zhenxin.qqbot.entity;

import lombok.Data;

import java.util.List;

/**
 * 表情表态用户列表
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2022/9/24 10:45
 */
@Data
public class ReactionUserList {
    /**
     * 用户列表
     */
    private List<User> users;
    /**
     * 分页参数，用于拉取下一页
     */
    private String cookie;
    /**
     * 是否已拉取完成到最后一页
     */
    private Boolean isEnd;

}
