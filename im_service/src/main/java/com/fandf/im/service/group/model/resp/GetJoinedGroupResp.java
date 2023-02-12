package com.fandf.im.service.group.model.resp;

import com.fandf.im.service.group.model.entity.ImGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * @author dongfengfan
 */
@Data
public class GetJoinedGroupResp {

    private Integer totalCount;

    private List<ImGroupEntity> groupList;

}
