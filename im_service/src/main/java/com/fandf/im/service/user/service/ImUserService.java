package com.fandf.im.service.user.service;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.user.model.entity.ImUserDataEntity;
import com.fandf.im.service.user.model.req.DeleteUserReq;
import com.fandf.im.service.user.model.req.GetUserInfoReq;
import com.fandf.im.service.user.model.req.ImportUserReq;
import com.fandf.im.service.user.model.req.ModifyUserInfoReq;
import com.fandf.im.service.user.model.resp.GetUserInfoResp;
import com.fandf.im.service.user.model.resp.ImportUserResp;

/**
 * @author fandongfeng
 * @date 2023/2/11 17:36
 */
public interface ImUserService {

    /**
     * 导入用户
     *
     * @param req
     * @return
     */
    ResponseVO<ImportUserResp> importUser(ImportUserReq req);

    /**
     * 获取用户详情
     *
     * @param req
     * @return
     */
    public ResponseVO<GetUserInfoResp> getUserInfo(GetUserInfoReq req);

    /**
     * @param userId 用户id
     * @param appId  应用id
     * @return
     */
    public ResponseVO<ImUserDataEntity> getSingleUserInfo(String userId, Integer appId);

    /**
     * 删除用户
     *
     * @param req
     * @return
     */
    public ResponseVO deleteUser(DeleteUserReq req);

    /**
     * 修改用户
     *
     * @param req
     * @return
     */
    public ResponseVO modifyUserInfo(ModifyUserInfoReq req);

}
