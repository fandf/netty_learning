package com.fandf.im.service.friendship.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;


/**
 * 审批好友请求
 *
 * @author dongfengfan
 */
@Data
public class ApproveFriendRequestReq extends RequestBase {

    private Long id;

    /**
     * 1同意 2拒绝
     */
    private Integer status;
}
