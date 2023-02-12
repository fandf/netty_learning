package com.fandf.im.service.group.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author dongfengfan
 */
@Data
public class TransferGroupReq extends RequestBase {

    @NotNull(message = "群id不能为空")
    private String groupId;

    private String ownerId;

}
