package com.fandf.im.service.user.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

/**
 * @author dongfengfan
 */
@Data
public class GetUserSequenceReq extends RequestBase {

    private String userId;

}
