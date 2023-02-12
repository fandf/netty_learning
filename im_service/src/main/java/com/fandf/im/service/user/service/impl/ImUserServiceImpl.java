package com.fandf.im.service.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fandf.im.common.ResponseVO;
import com.fandf.im.common.enums.DelFlagEnum;
import com.fandf.im.common.enums.UserErrorCode;
import com.fandf.im.common.exception.ApplicationException;
import com.fandf.im.service.user.dao.ImUserDataMapper;
import com.fandf.im.service.user.model.entity.ImUserDataEntity;
import com.fandf.im.service.user.model.req.DeleteUserReq;
import com.fandf.im.service.user.model.req.GetUserInfoReq;
import com.fandf.im.service.user.model.req.ImportUserReq;
import com.fandf.im.service.user.model.req.ModifyUserInfoReq;
import com.fandf.im.service.user.model.resp.GetUserInfoResp;
import com.fandf.im.service.user.model.resp.ImportUserResp;
import com.fandf.im.service.user.service.ImUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fandongfeng
 * @date 2023/2/11 17:36
 */
@Service
public class ImUserServiceImpl implements ImUserService {

    @Resource
    ImUserDataMapper imUserDataMapper;

    @Override
    public ResponseVO<ImportUserResp> importUser(ImportUserReq req) {
        if (req.getUserList().size() > 100) {
            //TODO 导入数量过多
        }

        List<String> successId = new ArrayList<>();
        List<String> errorId = new ArrayList<>();

        req.getUserList().forEach(e -> {
            try {
                int insert = imUserDataMapper.insert(e);
                if (insert == 1) {
                    successId.add(e.getUserId());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                errorId.add(e.getUserId());
            }


        });
        return ResponseVO.successResponse(ImportUserResp.of(successId, errorId));
    }


    @Override
    public ResponseVO<GetUserInfoResp> getUserInfo(GetUserInfoReq req) {
        QueryWrapper<ImUserDataEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("app_id", req.getAppId());
        queryWrapper.in("user_id", req.getUserIds());
        queryWrapper.eq("del_flag", DelFlagEnum.NORMAL.getCode());

        List<ImUserDataEntity> userDataEntities = imUserDataMapper.selectList(queryWrapper);
        Map<String, ImUserDataEntity> map = new HashMap<>();

        for (ImUserDataEntity data : userDataEntities) {
            map.put(data.getUserId(), data);
        }

        List<String> failUser = new ArrayList<>();
        for (String uid :
                req.getUserIds()) {
            if (!map.containsKey(uid)) {
                failUser.add(uid);
            }
        }

        GetUserInfoResp resp = new GetUserInfoResp();
        resp.setUserDataItem(userDataEntities);
        resp.setFailUser(failUser);
        return ResponseVO.successResponse(resp);
    }

    @Override
    public ResponseVO<ImUserDataEntity> getSingleUserInfo(String userId, Integer appId) {
        QueryWrapper<ImUserDataEntity> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("app_id", appId);
        objectQueryWrapper.eq("user_id", userId);
        objectQueryWrapper.eq("del_flag", DelFlagEnum.NORMAL.getCode());

        ImUserDataEntity ImUserDataEntity = imUserDataMapper.selectOne(objectQueryWrapper);
        if (ImUserDataEntity == null) {
            return ResponseVO.errorResponse(UserErrorCode.USER_IS_NOT_EXIST);
        }

        return ResponseVO.successResponse(ImUserDataEntity);
    }

    @Override
    public ResponseVO deleteUser(DeleteUserReq req) {
        ImUserDataEntity entity = new ImUserDataEntity();
        entity.setDelFlag(DelFlagEnum.DELETE.getCode());

        List<String> errorId = new ArrayList();
        List<String> successId = new ArrayList();

        for (String userId : req.getUserId()) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("app_id", req.getAppId());
            wrapper.eq("user_id", userId);
            wrapper.eq("del_flag", DelFlagEnum.NORMAL.getCode());
            int update = 0;

            try {
                update = imUserDataMapper.update(entity, wrapper);
                if (update > 0) {
                    successId.add(userId);
                } else {
                    errorId.add(userId);
                }
            } catch (Exception e) {
                errorId.add(userId);
            }
        }

        ImportUserResp resp = new ImportUserResp();
        resp.setSuccessId(successId);
        resp.setErrorId(errorId);
        return ResponseVO.successResponse(resp);
    }

    @Override
    @Transactional
    public ResponseVO modifyUserInfo(ModifyUserInfoReq req) {
        QueryWrapper query = new QueryWrapper<>();
        query.eq("app_id", req.getAppId());
        query.eq("user_id", req.getUserId());
        query.eq("del_flag", DelFlagEnum.NORMAL.getCode());
        ImUserDataEntity user = imUserDataMapper.selectOne(query);
        if (user == null) {
            throw new ApplicationException(UserErrorCode.USER_IS_NOT_EXIST);
        }

        ImUserDataEntity update = new ImUserDataEntity();
        BeanUtils.copyProperties(req, update);

        update.setAppId(null);
        update.setUserId(null);
        int update1 = imUserDataMapper.update(update, query);
        if (update1 == 1) {
            return ResponseVO.successResponse();
        }
        throw new ApplicationException(UserErrorCode.MODIFY_USER_ERROR);
    }
}
