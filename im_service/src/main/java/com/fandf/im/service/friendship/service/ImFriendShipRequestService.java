package com.fandf.im.service.friendship.service;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.friendship.model.req.ApproveFriendRequestReq;
import com.fandf.im.service.friendship.model.req.FriendDto;
import com.fandf.im.service.friendship.model.req.ReadFriendShipRequestReq;


/**
 * @author dongfengfan
 */
public interface ImFriendShipRequestService {

    public ResponseVO addFienshipRequest(String fromId, FriendDto dto, Integer appId);

    public ResponseVO approveFriendRequest(ApproveFriendRequestReq req);

    public ResponseVO readFriendShipRequestReq(ReadFriendShipRequestReq req);

    public ResponseVO getFriendRequest(String fromId, Integer appId);
}
