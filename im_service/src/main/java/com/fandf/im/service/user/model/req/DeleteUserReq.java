package com.fandf.im.service.user.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * @author dongfengfan
 */
@Data
public class DeleteUserReq extends RequestBase {

    @NotEmpty(message = "用户id不能为空")
    private List<String> userId;
}
