package com.fandf.im.service.friendship.controller;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.friendship.model.req.AddFriendShipGroupMemberReq;
import com.fandf.im.service.friendship.model.req.AddFriendShipGroupReq;
import com.fandf.im.service.friendship.model.req.DeleteFriendShipGroupMemberReq;
import com.fandf.im.service.friendship.model.req.DeleteFriendShipGroupReq;
import com.fandf.im.service.friendship.service.ImFriendShipGroupMemberService;
import com.fandf.im.service.friendship.service.ImFriendShipGroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongfengfan
 */
@RestController
@RequestMapping("v1/friendship/group")
public class ImFriendShipGroupController {

    @Resource
    ImFriendShipGroupService imFriendShipGroupService;

    @Resource
    ImFriendShipGroupMemberService imFriendShipGroupMemberService;


    @RequestMapping("/add")
    public ResponseVO add(@RequestBody @Validated AddFriendShipGroupReq req, Integer appId)  {
        req.setAppId(appId);
        return imFriendShipGroupService.addGroup(req);
    }

    @RequestMapping("/del")
    public ResponseVO del(@RequestBody @Validated DeleteFriendShipGroupReq req, Integer appId)  {
        req.setAppId(appId);
        return imFriendShipGroupService.deleteGroup(req);
    }

    @RequestMapping("/member/add")
    public ResponseVO memberAdd(@RequestBody @Validated AddFriendShipGroupMemberReq req, Integer appId)  {
        req.setAppId(appId);
        return imFriendShipGroupMemberService.addGroupMember(req);
    }

    @RequestMapping("/member/del")
    public ResponseVO memberdel(@RequestBody @Validated DeleteFriendShipGroupMemberReq req, Integer appId)  {
        req.setAppId(appId);
        return imFriendShipGroupMemberService.delGroupMember(req);
    }


}
