package com.fandf.im.service.friendship.model.req;

import com.fandf.im.common.enums.CheckFriendShipTypeEnum;
import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 校验好友关系
 *
 * @author dongfengfan
 */
@Data
public class CheckFriendShipReq extends RequestBase {

    @NotBlank(message = "fromId不能为空")
    private String fromId;

    @NotEmpty(message = "toIds不能为空")
    private List<String> toIds;

    /**
     * 参考腾讯云
     * 单向校验：我的好友列表里有的用户
     * 双向校验：我的好友列表，并且好友列表里面有我的用户
     * {@link CheckFriendShipTypeEnum}
     */
    @NotNull(message = "checkType不能为空")
    private Integer checkType;
}
