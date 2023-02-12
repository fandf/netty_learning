package com.fandf.im.service.friendship.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.friendship.dao.ImFriendShipGroupMemberMapper;
import com.fandf.im.service.friendship.model.entity.ImFriendShipGroupEntity;
import com.fandf.im.service.friendship.model.entity.ImFriendShipGroupMemberEntity;
import com.fandf.im.service.friendship.model.req.AddFriendShipGroupMemberReq;
import com.fandf.im.service.friendship.model.req.DeleteFriendShipGroupMemberReq;
import com.fandf.im.service.friendship.service.ImFriendShipGroupMemberService;
import com.fandf.im.service.friendship.service.ImFriendShipGroupService;
import com.fandf.im.service.user.model.entity.ImUserDataEntity;
import com.fandf.im.service.user.service.ImUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dongfengfan
 */
@Service
public class ImFriendShipGroupMemberServiceImpl implements ImFriendShipGroupMemberService {

    @Resource
    ImFriendShipGroupMemberMapper imFriendShipGroupMemberMapper;

    @Resource
    ImFriendShipGroupService imFriendShipGroupService;

    @Resource
    ImUserService imUserService;

    @Resource
    ImFriendShipGroupMemberService thisService;

    @Override
    @Transactional
    public ResponseVO addGroupMember(AddFriendShipGroupMemberReq req) {

        ResponseVO<ImFriendShipGroupEntity> group = imFriendShipGroupService
                .getGroup(req.getFromId(),req.getGroupName(),req.getAppId());
        if(!group.isOk()){
            return group;
        }

        List<String> successId = new ArrayList<>();
        for (String toId : req.getToIds()) {
            ResponseVO<ImUserDataEntity> singleUserInfo = imUserService.getSingleUserInfo(toId, req.getAppId());
            if(singleUserInfo.isOk()){
                int i = thisService.doAddGroupMember(group.getData().getGroupId(), toId);
                if(i == 1){
                    successId.add(toId);
                }
            }
        }

        return ResponseVO.successResponse(successId);
    }

    @Override
    public ResponseVO delGroupMember(DeleteFriendShipGroupMemberReq req) {
        ResponseVO<ImFriendShipGroupEntity> group = imFriendShipGroupService
                .getGroup(req.getFromId(),req.getGroupName(),req.getAppId());
        if(!group.isOk()){
            return group;
        }

        ArrayList list = new ArrayList();
        for (String toId : req.getToIds()) {
            ResponseVO<ImUserDataEntity> singleUserInfo = imUserService.getSingleUserInfo(toId, req.getAppId());
            if(singleUserInfo.isOk()){
                int i = deleteGroupMember(group.getData().getGroupId(), req.getToIds());
                if(i == 1){
                    list.add(toId);
                }
            }
        }
        return ResponseVO.successResponse(list);
    }

    @Override
    public int doAddGroupMember(Long groupId, String toId) {
        ImFriendShipGroupMemberEntity imFriendShipGroupMemberEntity = new ImFriendShipGroupMemberEntity();
        imFriendShipGroupMemberEntity.setGroupId(groupId);
        imFriendShipGroupMemberEntity.setToId(toId);
        try {
            int insert = imFriendShipGroupMemberMapper.insert(imFriendShipGroupMemberEntity);
            return insert;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteGroupMember(Long groupId, List<String> toIds) {
        QueryWrapper<ImFriendShipGroupMemberEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("group_id",groupId);
        queryWrapper.in("to_id",toIds);

        try {
            int delete = imFriendShipGroupMemberMapper.delete(queryWrapper);
//            int insert = imFriendShipGroupMemberMapper.insert(imFriendShipGroupMemberEntity);
            return delete;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int clearGroupMember(Long groupId) {
        QueryWrapper<ImFriendShipGroupMemberEntity> query = new QueryWrapper<>();
        query.eq("group_id",groupId);
        int delete = imFriendShipGroupMemberMapper.delete(query);
        return delete;
    }
}
