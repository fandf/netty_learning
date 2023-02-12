package com.fandf.im.service.friendship.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 好友分组表
 *
 * @author dongfengfan
 */
@Data
@TableName("im_friendship_group")
public class ImFriendShipGroupEntity {

    @TableId(value = "group_id", type = IdType.AUTO)
    private Long groupId;

    private String fromId;

    private Integer appId;

    private String groupName;
    /**
     * 备注
     */
    private Long createTime;

    /**
     * 备注
     */
    private Long updateTime;

    /**
     * 序列号
     */
    private Long sequence;

    private int delFlag;


}
