package com.fandf.im.service.friendship.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fandf.im.common.ResponseVO;
import com.fandf.im.common.enums.ApproveFriendRequestStatusEnum;
import com.fandf.im.common.enums.FriendShipErrorCode;
import com.fandf.im.common.exception.ApplicationException;
import com.fandf.im.service.friendship.dao.ImFriendShipRequestMapper;
import com.fandf.im.service.friendship.model.entity.ImFriendShipRequestEntity;
import com.fandf.im.service.friendship.model.req.ApproveFriendRequestReq;
import com.fandf.im.service.friendship.model.req.FriendDto;
import com.fandf.im.service.friendship.model.req.ReadFriendShipRequestReq;
import com.fandf.im.service.friendship.service.ImFriendService;
import com.fandf.im.service.friendship.service.ImFriendShipRequestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author dongfengfan
 */
@Service
public class ImFriendShipRequestServiceImpl implements ImFriendShipRequestService {

    @Resource
    ImFriendShipRequestMapper imFriendShipRequestMapper;

    @Resource
    ImFriendService imFriendShipService;

    @Override
    public ResponseVO getFriendRequest(String fromId, Integer appId) {

        QueryWrapper<ImFriendShipRequestEntity> query = new QueryWrapper();
        query.eq("app_id", appId);
        query.eq("to_id", fromId);

        List<ImFriendShipRequestEntity> requestList = imFriendShipRequestMapper.selectList(query);

        return ResponseVO.successResponse(requestList);
    }


    //A + B
    @Override
    public ResponseVO addFienshipRequest(String fromId, FriendDto dto, Integer appId) {

        QueryWrapper<ImFriendShipRequestEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("app_id",appId);
        queryWrapper.eq("from_id",fromId);
        queryWrapper.eq("to_id",dto.getToId());
        ImFriendShipRequestEntity entity = imFriendShipRequestMapper.selectOne(queryWrapper);

        if(entity == null){
            entity = new ImFriendShipRequestEntity();
            entity.setAddSource(dto.getAddSource());
            entity.setAddWording(dto.getAddWording());
            entity.setAppId(appId);
            entity.setFromId(fromId);
            entity.setToId(dto.getToId());
            entity.setReadStatus(0);
            entity.setApproveStatus(0);
            entity.setRemark(dto.getRemark());
            entity.setCreateTime(System.currentTimeMillis());
            imFriendShipRequestMapper.insert(entity);
        }else {
            //修改记录内容 和更新时间
            if(StringUtils.isNotBlank(dto.getAddSource())){
                entity.setAddWording(dto.getAddWording());
            }
            if(StringUtils.isNotBlank(dto.getRemark())){
                entity.setRemark(dto.getRemark());
            }
            if(StringUtils.isNotBlank(dto.getAddWording())){
                entity.setAddWording(dto.getAddWording());
            }
            entity.setApproveStatus(0);
            entity.setReadStatus(0);
            imFriendShipRequestMapper.updateById(entity);
        }

        return ResponseVO.successResponse();
    }

    @Override
    @Transactional
    public ResponseVO approveFriendRequest(ApproveFriendRequestReq req) {

        ImFriendShipRequestEntity imFriendShipRequestEntity = imFriendShipRequestMapper.selectById(req.getId());
        if(imFriendShipRequestEntity == null){
            throw new ApplicationException(FriendShipErrorCode.FRIEND_REQUEST_IS_NOT_EXIST);
        }

        if(!req.getOperator().equals(imFriendShipRequestEntity.getToId())){
            //只能审批发给自己的好友请求
            throw new ApplicationException(FriendShipErrorCode.NOT_APPROVE_OTHER_MAN_REQUEST);
        }

        ImFriendShipRequestEntity update = new ImFriendShipRequestEntity();
        update.setApproveStatus(req.getStatus());
        update.setUpdateTime(System.currentTimeMillis());
        update.setId(req.getId());
        imFriendShipRequestMapper.updateById(update);

        if(ApproveFriendRequestStatusEnum.AGREE.getCode() == req.getStatus()){
            //同意 ===> 去执行添加好友逻辑
            FriendDto dto = new FriendDto();
            dto.setAddSource(imFriendShipRequestEntity.getAddSource());
            dto.setAddWording(imFriendShipRequestEntity.getAddWording());
            dto.setRemark(imFriendShipRequestEntity.getRemark());
            dto.setToId(imFriendShipRequestEntity.getToId());
            ResponseVO responseVO = imFriendShipService.doAddFriend(req,imFriendShipRequestEntity.getFromId(), dto,req.getAppId());
//            if(!responseVO.isOk()){
////                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//                return responseVO;
//            }
            if(!responseVO.isOk() && responseVO.getCode() != FriendShipErrorCode.TO_IS_YOUR_FRIEND.getCode()){
                return responseVO;
            }
        }

        return ResponseVO.successResponse();
    }

    @Override
    public ResponseVO readFriendShipRequestReq(ReadFriendShipRequestReq req) {
        QueryWrapper<ImFriendShipRequestEntity> query = new QueryWrapper<>();
        query.eq("app_id", req.getAppId());
        query.eq("to_id", req.getFromId());

        ImFriendShipRequestEntity update = new ImFriendShipRequestEntity();
        update.setReadStatus(1);
        imFriendShipRequestMapper.update(update, query);

        return ResponseVO.successResponse();
    }

}
