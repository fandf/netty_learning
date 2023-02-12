package com.fandf.im.service.group.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author dongfengfan
 */
@Data
public class RemoveGroupMemberReq extends RequestBase {

    @NotBlank(message = "群id不能为空")
    private String groupId;

    private String memberId;

}
