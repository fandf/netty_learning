package com.fandf.im.service.friendship.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @author dongfengfan
 */
@Data
public class GetAllFriendShipReq extends RequestBase {

    @NotBlank(message = "用户id不能为空")
    private String fromId;
}
