package com.fandf.im.service.group.controller;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.group.model.req.*;
import com.fandf.im.service.group.service.ImGroupMemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongfengfan
 */
@RestController
@RequestMapping("v1/group/member")
public class ImGroupMemberController {

    @Resource
    ImGroupMemberService groupMemberService;

    @RequestMapping("/importGroupMember")
    public ResponseVO importGroupMember(@RequestBody @Validated ImportGroupMemberReq req, Integer appId, String identifier)  {
        req.setAppId(appId);
        req.setOperator(identifier);
        return groupMemberService.importGroupMember(req);
    }

    @RequestMapping("/add")
    public ResponseVO addMember(@RequestBody @Validated AddGroupMemberReq req, Integer appId, String identifier)  {
        req.setAppId(appId);
        req.setOperator(identifier);
        return groupMemberService.addMember(req);
    }

    @RequestMapping("/remove")
    public ResponseVO removeMember(@RequestBody @Validated RemoveGroupMemberReq req, Integer appId, String identifier)  {
        req.setAppId(appId);
        req.setOperator(identifier);
        return groupMemberService.removeMember(req);
    }

    @RequestMapping("/update")
    public ResponseVO updateGroupMember(@RequestBody @Validated UpdateGroupMemberReq req, Integer appId, String identifier)  {
        req.setAppId(appId);
        req.setOperator(identifier);
        return groupMemberService.updateGroupMember(req);
    }

    @RequestMapping("/speak")
    public ResponseVO speak(@RequestBody @Validated SpeakMemberReq req, Integer appId, String identifier)  {
        req.setAppId(appId);
        req.setOperator(identifier);
        return groupMemberService.speak(req);
    }

}
