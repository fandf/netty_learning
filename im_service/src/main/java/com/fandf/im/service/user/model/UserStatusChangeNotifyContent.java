package com.fandf.im.service.user.model;

import com.fandf.im.common.model.ClientInfo;
import lombok.Data;

/**
 * status区分是上线还是下线
 *
 * @author dongfengfan
 */
@Data
public class UserStatusChangeNotifyContent extends ClientInfo {


    private String userId;

    //服务端状态 1上线 2离线
    private Integer status;


}
