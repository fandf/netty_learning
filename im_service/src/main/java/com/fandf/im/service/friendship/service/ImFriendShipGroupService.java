package com.fandf.im.service.friendship.service;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.friendship.model.entity.ImFriendShipGroupEntity;
import com.fandf.im.service.friendship.model.req.AddFriendShipGroupReq;
import com.fandf.im.service.friendship.model.req.DeleteFriendShipGroupReq;

/**
 * @author dongfengfan
 */
public interface ImFriendShipGroupService {

    public ResponseVO addGroup(AddFriendShipGroupReq req);

    public ResponseVO deleteGroup(DeleteFriendShipGroupReq req);

    public ResponseVO<ImFriendShipGroupEntity> getGroup(String fromId, String groupName, Integer appId);


}
