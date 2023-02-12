package com.fandf.im.service.user.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import java.util.List;


/**
 * @author dongfengfan
 */
@Data
public class GetUserInfoReq extends RequestBase {

    private List<String> userIds;


}
