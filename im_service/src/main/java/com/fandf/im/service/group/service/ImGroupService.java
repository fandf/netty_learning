package com.fandf.im.service.group.service;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.group.model.entity.ImGroupEntity;
import com.fandf.im.service.group.model.req.*;

/**
 * 群组服务
 *
 * @author dongfengfan
 */
public interface ImGroupService {

    /**
     * 导入群组
     *
     * @param req
     * @return
     */
    public ResponseVO importGroup(ImportGroupReq req);

    /**
     * 创建群组
     *
     * @param req
     * @return
     */
    public ResponseVO createGroup(CreateGroupReq req);

    /**
     * 修改群基本信息
     *
     * @param req
     * @return
     */
    public ResponseVO updateBaseGroupInfo(UpdateGroupReq req);

    /**
     * 获取加入的群组
     *
     * @param req
     * @return
     */
    public ResponseVO getJoinedGroup(GetJoinedGroupReq req);

    /**
     * 解散群组
     *
     * @param req
     * @return
     */
    public ResponseVO destroyGroup(DestroyGroupReq req);

    /**
     * 转让
     *
     * @param req
     * @return
     */
    public ResponseVO transferGroup(TransferGroupReq req);

    /**
     * 获取群信息
     *
     * @param groupId
     * @param appId
     * @return
     */
    public ResponseVO<ImGroupEntity> getGroup(String groupId, Integer appId);

    /**
     * 获取群信息
     *
     * @param req
     * @return
     */
    public ResponseVO getGroup(GetGroupReq req);

    /**
     * 群禁言
     *
     * @param req
     * @return
     */
    public ResponseVO muteGroup(MuteGroupReq req);

}
