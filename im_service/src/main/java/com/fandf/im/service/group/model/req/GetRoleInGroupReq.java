package com.fandf.im.service.group.model.req;

import com.fandf.im.common.model.RequestBase;
import lombok.Data;

import java.util.List;

/**
 * @author dongfengfan
 */
@Data
public class GetRoleInGroupReq extends RequestBase {

    private String groupId;

    private List<String> memberId;
}
