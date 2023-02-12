package com.fandf.im.service.friendship.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 好友分组成员表
 *
 * @author dongfengfan
 */
@Data
@TableName("im_friendship_group_member")
public class ImFriendShipGroupMemberEntity {

    @TableId(value = "group_id")
    private Long groupId;
    @TableId(value = "to_id")
    private String toId;

}
