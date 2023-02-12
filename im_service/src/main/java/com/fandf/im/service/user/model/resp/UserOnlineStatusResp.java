package com.fandf.im.service.user.model.resp;

import com.fandf.im.common.model.UserSession;
import lombok.Data;

import java.util.List;

/**
 * @author dongfengfan
 */
@Data
public class UserOnlineStatusResp {

    private List<UserSession> session;

    private String customText;

    private Integer customStatus;

}
