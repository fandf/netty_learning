package com.fandf.im.service.friendship.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fandf.im.common.ResponseVO;
import com.fandf.im.common.enums.DelFlagEnum;
import com.fandf.im.common.enums.FriendShipErrorCode;
import com.fandf.im.service.friendship.dao.ImFriendShipGroupMapper;
import com.fandf.im.service.friendship.model.entity.ImFriendShipGroupEntity;
import com.fandf.im.service.friendship.model.req.AddFriendShipGroupMemberReq;
import com.fandf.im.service.friendship.model.req.AddFriendShipGroupReq;
import com.fandf.im.service.friendship.model.req.DeleteFriendShipGroupReq;
import com.fandf.im.service.friendship.service.ImFriendShipGroupMemberService;
import com.fandf.im.service.friendship.service.ImFriendShipGroupService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author dongfengfan
 */
@Service
public class ImFriendShipGroupServiceImpl implements ImFriendShipGroupService {

    @Resource
    ImFriendShipGroupMapper imFriendShipGroupMapper;

    @Resource
    ImFriendShipGroupMemberService imFriendShipGroupMemberService;

    @Override
    @Transactional
    public ResponseVO addGroup(AddFriendShipGroupReq req) {

        QueryWrapper<ImFriendShipGroupEntity> query = new QueryWrapper<>();
        query.eq("group_name", req.getGroupName());
        query.eq("app_id", req.getAppId());
        query.eq("from_id", req.getFromId());
//        query.eq("del_flag", DelFlagEnum.NORMAL.getCode());

        ImFriendShipGroupEntity entity = imFriendShipGroupMapper.selectOne(query);

        if (entity != null && entity.getDelFlag() == DelFlagEnum.NORMAL.getCode()) {
            return ResponseVO.errorResponse(FriendShipErrorCode.FRIEND_SHIP_GROUP_IS_EXIST);
        }

        //写入db
        ImFriendShipGroupEntity insert;
        if (entity == null) {
            insert = new ImFriendShipGroupEntity();
            insert.setAppId(req.getAppId());
            insert.setCreateTime(System.currentTimeMillis());
            insert.setDelFlag(DelFlagEnum.NORMAL.getCode());
            insert.setGroupName(req.getGroupName());
            insert.setFromId(req.getFromId());
            try {
                int insert1 = imFriendShipGroupMapper.insert(insert);
                if (insert1 != 1) {
                    return ResponseVO.errorResponse(FriendShipErrorCode.FRIEND_SHIP_GROUP_CREATE_ERROR);
                }
            } catch (DuplicateKeyException e) {
                e.getStackTrace();
                return ResponseVO.errorResponse(FriendShipErrorCode.FRIEND_SHIP_GROUP_IS_EXIST);
            }
        } else {
            insert = entity;
            insert.setAppId(req.getAppId());
            insert.setUpdateTime(System.currentTimeMillis());
            insert.setDelFlag(DelFlagEnum.NORMAL.getCode());
            insert.setGroupName(req.getGroupName());
            insert.setFromId(req.getFromId());
            imFriendShipGroupMapper.updateById(insert);
        }
        if (CollUtil.isNotEmpty(req.getToIds())) {
            AddFriendShipGroupMemberReq addFriendShipGroupMemberReq = new AddFriendShipGroupMemberReq();
            addFriendShipGroupMemberReq.setFromId(req.getFromId());
            addFriendShipGroupMemberReq.setGroupName(req.getGroupName());
            addFriendShipGroupMemberReq.setToIds(req.getToIds());
            addFriendShipGroupMemberReq.setAppId(req.getAppId());
            imFriendShipGroupMemberService.addGroupMember(addFriendShipGroupMemberReq);
            return ResponseVO.successResponse();
        }
        return ResponseVO.successResponse();
    }

    @Override
    @Transactional
    public ResponseVO deleteGroup(DeleteFriendShipGroupReq req) {

        for (String groupName : req.getGroupName()) {
            QueryWrapper<ImFriendShipGroupEntity> query = new QueryWrapper<>();
            query.eq("group_name", groupName);
            query.eq("app_id", req.getAppId());
            query.eq("from_id", req.getFromId());
            query.eq("del_flag", DelFlagEnum.NORMAL.getCode());

            ImFriendShipGroupEntity entity = imFriendShipGroupMapper.selectOne(query);

            if (entity != null) {
                ImFriendShipGroupEntity update = new ImFriendShipGroupEntity();
                update.setGroupId(entity.getGroupId());
                update.setDelFlag(DelFlagEnum.DELETE.getCode());
                imFriendShipGroupMapper.updateById(update);
                imFriendShipGroupMemberService.clearGroupMember(entity.getGroupId());

            }
        }
        return ResponseVO.successResponse();
    }

    @Override
    public ResponseVO getGroup(String fromId, String groupName, Integer appId) {
        QueryWrapper<ImFriendShipGroupEntity> query = new QueryWrapper<>();
        query.eq("group_name", groupName);
        query.eq("app_id", appId);
        query.eq("from_id", fromId);
        query.eq("del_flag", DelFlagEnum.NORMAL.getCode());

        ImFriendShipGroupEntity entity = imFriendShipGroupMapper.selectOne(query);
        if (entity == null) {
            return ResponseVO.errorResponse(FriendShipErrorCode.FRIEND_SHIP_GROUP_IS_NOT_EXIST);
        }
        return ResponseVO.successResponse(entity);
    }

}
