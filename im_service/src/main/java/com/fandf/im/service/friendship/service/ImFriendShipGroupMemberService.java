package com.fandf.im.service.friendship.service;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.friendship.model.req.AddFriendShipGroupMemberReq;
import com.fandf.im.service.friendship.model.req.DeleteFriendShipGroupMemberReq;

/**
 * @author dongfengfan
 */
public interface ImFriendShipGroupMemberService {

    /**
     * 添加组成员
     *
     * @param req
     * @return
     */
    public ResponseVO addGroupMember(AddFriendShipGroupMemberReq req);

    /**
     * 删除组成员
     *
     * @param req
     * @return
     */
    public ResponseVO delGroupMember(DeleteFriendShipGroupMemberReq req);

    /**
     * 添加组成员
     *
     * @param groupId
     * @param toId
     * @return
     */
    public int doAddGroupMember(Long groupId, String toId);

    /**
     * 清空组成员
     *
     * @param groupId
     * @return
     */
    public int clearGroupMember(Long groupId);
}
