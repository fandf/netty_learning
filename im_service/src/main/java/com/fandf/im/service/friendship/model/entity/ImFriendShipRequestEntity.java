package com.fandf.im.service.friendship.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * @author dongfengfan
 */
@Data
@TableName("im_friendship_request")
public class ImFriendShipRequestEntity extends Model<ImFriendShipRequestEntity> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer appId;

    private String fromId;

    private String toId;
    /** 备注*/
    private String remark;

    //是否已读 1已读
    private Integer readStatus;

    /** 好友来源*/
    private String addSource;

    private String addWording;

    //审批状态 1同意 2拒绝
    private Integer approveStatus;

    private Long createTime;

    private Long updateTime;

    /** 序列号*/
    private Long sequence;




}
