package com.fandf.im.service.user.model.req;

import com.fandf.im.common.model.RequestBase;
import com.fandf.im.service.user.model.entity.ImUserDataEntity;
import lombok.Data;

import java.util.List;

/**
 * @author fandongfeng
 * @date 2023/2/11 21:06
 */
@Data
public class ImportUserReq extends RequestBase {

    private List<ImUserDataEntity> userList;

}
