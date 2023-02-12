package com.fandf.im.service.group.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

/**
 * @author dongfengfan
 */
@Data
public class GetGroupReq extends RequestBase {

    private String groupId;

}
