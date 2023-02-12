package com.fandf.im.service.friendship.controller;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.friendship.model.req.*;
import com.fandf.im.service.friendship.model.resp.ImportFriendShipResp;
import com.fandf.im.service.friendship.service.ImFriendService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongfengfan
 */
@RestController
@RequestMapping("v1/friendship")
public class ImFriendShipController {

    @Resource
    ImFriendService imFriendShipService;

    @RequestMapping("/importFriendShip")
    public ResponseVO<ImportFriendShipResp> importFriendShip(@RequestBody @Validated ImporFriendShipReq req){
        return imFriendShipService.importFriendShip(req);
    }

    @RequestMapping("/addFriend")
    public ResponseVO addFriend(@RequestBody @Validated AddFriendReq req){
        return imFriendShipService.addFriend(req);
    }

    @RequestMapping("/updateFriend")
    public ResponseVO updateFriend(@RequestBody @Validated UpdateFriendReq req){
        return imFriendShipService.updateFriend(req);
    }

    @RequestMapping("/deleteFriend")
    public ResponseVO deleteFriend(@RequestBody @Validated DeleteFriendReq req){
        return imFriendShipService.deleteFriend(req);
    }

    @RequestMapping("/deleteAllFriend")
    public ResponseVO deleteAllFriend(@RequestBody @Validated DeleteAllFriendReq req){
        return imFriendShipService.deleteAllFriend(req);
    }

    @RequestMapping("/getAllFriendShip")
    public ResponseVO getAllFriendShip(@RequestBody @Validated GetAllFriendShipReq req){
        return imFriendShipService.getAllFriendShip(req);
    }

    @RequestMapping("/getRelation")
    public ResponseVO getRelation(@RequestBody @Validated GetRelationReq req){
        return imFriendShipService.getRelation(req);
    }

    @RequestMapping("/checkFriend")
    public ResponseVO checkFriendship(@RequestBody @Validated CheckFriendShipReq req){
        return imFriendShipService.checkFriendship(req);
    }

    @RequestMapping("/addBlack")
    public ResponseVO addBlack(@RequestBody @Validated AddFriendShipBlackReq req){
        return imFriendShipService.addBlack(req);
    }

    @RequestMapping("/deleteBlack")
    public ResponseVO deleteBlack(@RequestBody @Validated DeleteBlackReq req){
        return imFriendShipService.deleteBlack(req);
    }

    @RequestMapping("/checkBlck")
    public ResponseVO checkBlack(@RequestBody @Validated CheckFriendShipReq req){
        return imFriendShipService.checkBlack(req);
    }


}
