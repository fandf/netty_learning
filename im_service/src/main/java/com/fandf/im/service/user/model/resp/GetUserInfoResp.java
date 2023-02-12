package com.fandf.im.service.user.model.resp;

import com.fandf.im.service.user.model.entity.ImUserDataEntity;
import lombok.Data;

import java.util.List;

/**
 * @author dongfengfan
 */
@Data
public class GetUserInfoResp {

    private List<ImUserDataEntity> userDataItem;

    private List<String> failUser;


}
