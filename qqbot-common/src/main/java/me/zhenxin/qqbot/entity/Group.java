package me.zhenxin.qqbot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 群聊
 *
 * @author 真心
 * @since 2023/12/11 9:55
 */
@Data
public class Group {
    /**
     * 群聊OpenId
     */
    @JSONField(name = "group_openid")
    private String groupOpenId;
    /**
     * 操作者OpenId
     */
    @JSONField(name = "op_member_openid")
    private String opMemberOpenId;
    /**
     * 加入时间戳
     */
    @JSONField(name = "timestamp")
    private Long timestamp;
}
