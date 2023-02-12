package com.fandf.im.service.friendship.service;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.common.model.RequestBase;
import com.fandf.im.service.friendship.model.req.*;
import com.fandf.im.service.friendship.model.resp.ImportFriendShipResp;
import com.fandf.im.service.user.model.entity.ImUserDataEntity;

/**
 * @author dongfengfan
 */
public interface ImFriendService {

    /**
     * 导入好友
     * 第三方直接导入好友使用
     *
     * @param req
     * @return
     */
    public ResponseVO<ImportFriendShipResp> importFriendShip(ImporFriendShipReq req);

    /**
     * 添加好友
     *
     * @param req
     * @return
     */
    public ResponseVO<ImUserDataEntity> addFriend(AddFriendReq req);

    /**
     * 修改好友
     *
     * @param req
     * @return
     */
    public ResponseVO updateFriend(UpdateFriendReq req);

    /**
     * 删除好友
     *
     * @param req
     * @return
     */
    public ResponseVO deleteFriend(DeleteFriendReq req);

    /**
     * 删除所有好友
     *
     * @param req
     * @return
     */
    public ResponseVO deleteAllFriend(DeleteAllFriendReq req);

    /**
     * 获取所有好友关系
     *
     * @param req
     * @return
     */
    public ResponseVO getAllFriendShip(GetAllFriendShipReq req);

    /**
     * 获取指定好友关系
     *
     * @param req
     * @return
     */
    public ResponseVO getRelation(GetRelationReq req);

    /**
     * 添加好友
     *
     * @param requestBase
     * @param fromId
     * @param dto
     * @param appId
     * @return
     */
    public ResponseVO doAddFriend(RequestBase requestBase, String fromId, FriendDto dto, Integer appId);

    /**
     * 检查好友关系
     *
     * @param req
     * @return
     */
    public ResponseVO checkFriendship(CheckFriendShipReq req);

    /**
     * 添加黑名单
     *
     * @param req
     * @return
     */
    public ResponseVO addBlack(AddFriendShipBlackReq req);

    /**
     * 移除黑名单
     *
     * @param req
     * @return
     */
    public ResponseVO deleteBlack(DeleteBlackReq req);

    /**
     * 检查黑名单
     *
     * @param req
     * @return
     */
    public ResponseVO checkBlack(CheckFriendShipReq req);

}
