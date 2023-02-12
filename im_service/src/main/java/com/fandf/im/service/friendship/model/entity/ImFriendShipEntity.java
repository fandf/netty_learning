package com.fandf.im.service.friendship.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * @author dongfengfan
 */
@Data
@TableName("im_friendship")
public class ImFriendShipEntity extends Model<ImFriendShipEntity> {

    @TableField(value = "app_id")
    private Integer appId;

    @TableField(value = "from_id")
    private String fromId;

    @TableField(value = "to_id")
    private String toId;
    /** 备注*/
    private String remark;
    /** 状态 1正常 2删除*/
    private Integer status;
    /** 状态 1正常 2拉黑*/
    private Integer black;
    private Long createTime;
    /** 好友关系序列号*/
    private Long friendSequence;

    /** 黑名单关系序列号*/
    private Long blackSequence;
    /** 好友来源*/
    private String addSource;

    private String extra;

}
