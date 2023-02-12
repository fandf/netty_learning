package com.fandf.im.service.friendship.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * 删除好友请求
 *
 * @author dongfengfan
 */
@Data
public class DeleteFriendReq extends RequestBase {

    @NotBlank(message = "fromId不能为空")
    private String fromId;

    @NotBlank(message = "toId不能为空")
    private String toId;

}
