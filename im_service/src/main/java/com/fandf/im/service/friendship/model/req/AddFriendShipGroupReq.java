package com.fandf.im.service.friendship.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * @author dongfengfan
 */
@Data
public class AddFriendShipGroupReq extends RequestBase {

    @NotBlank(message = "fromId不能为空")
    public String fromId;

    @NotBlank(message = "分组名称不能为空")
    private String groupName;

    private List<String> toIds;

}
