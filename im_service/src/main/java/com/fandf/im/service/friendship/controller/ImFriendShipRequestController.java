package com.fandf.im.service.friendship.controller;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.friendship.model.req.ApproveFriendRequestReq;
import com.fandf.im.service.friendship.model.req.GetFriendShipRequestReq;
import com.fandf.im.service.friendship.model.req.ReadFriendShipRequestReq;
import com.fandf.im.service.friendship.service.ImFriendShipRequestService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 好友申请
 *
 * @author dongfengfan
 */
@RestController
@RequestMapping("v1/friendshipRequest")
public class ImFriendShipRequestController {

    @Resource
    ImFriendShipRequestService imFriendShipRequestService;

    @RequestMapping("/approveFriendRequest")
    public ResponseVO approveFriendRequest(@RequestBody @Validated ApproveFriendRequestReq req, Integer appId, String identifier) {
        req.setAppId(appId);
        req.setOperator(identifier);
        return imFriendShipRequestService.approveFriendRequest(req);
    }

    @RequestMapping("/getFriendRequest")
    public ResponseVO getFriendRequest(@RequestBody @Validated GetFriendShipRequestReq req, Integer appId) {
        req.setAppId(appId);
        return imFriendShipRequestService.getFriendRequest(req.getFromId(), req.getAppId());
    }

    @RequestMapping("/readFriendShipRequestReq")
    public ResponseVO readFriendShipRequestReq(@RequestBody @Validated ReadFriendShipRequestReq req, Integer appId) {
        req.setAppId(appId);
        return imFriendShipRequestService.readFriendShipRequestReq(req);
    }


}
