package com.fandf.im.service.group.service;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.group.model.req.*;
import com.fandf.im.service.group.model.resp.GetRoleInGroupResp;

import java.util.Collection;
import java.util.List;

/**
 * @author dongfengfan
 */
public interface ImGroupMemberService {

    /**
     * 导入群组成员
     *
     * @param req
     * @return
     */
    public ResponseVO importGroupMember(ImportGroupMemberReq req);

    /**
     * 拉人入群
     *
     * @param req
     * @return
     */
    public ResponseVO addMember(AddGroupMemberReq req);

    /**
     * 移除群聊
     *
     * @param req
     * @return
     */
    public ResponseVO removeMember(RemoveGroupMemberReq req);

    /**
     * 加入群聊
     *
     * @param groupId
     * @param appId
     * @param dto
     * @return
     */
    public ResponseVO addGroupMember(String groupId, Integer appId, GroupMemberDto dto);

    /**
     * 移出群聊
     *
     * @param groupId
     * @param appId
     * @param memberId
     * @return
     */
    public ResponseVO removeGroupMember(String groupId, Integer appId, String memberId);

    /**
     * 查询用户在群内的角色
     *
     * @param groupId
     * @param memberId
     * @param appId
     * @return
     */
    public ResponseVO<GetRoleInGroupResp> getRoleInGroupOne(String groupId, String memberId, Integer appId);

    /**
     * 获取成员加入的群组
     *
     * @param req
     * @return
     */
    public ResponseVO<Collection<String>> getMemberJoinedGroup(GetJoinedGroupReq req);

    /**
     * 查询群成员
     *
     * @param groupId
     * @param appId
     * @return
     */
    public ResponseVO<List<GroupMemberDto>> getGroupMember(String groupId, Integer appId);

    /**
     * 群成员id
     *
     * @param groupId
     * @param appId
     * @return
     */
    public List<String> getGroupMemberId(String groupId, Integer appId);

    public List<GroupMemberDto> getGroupManager(String groupId, Integer appId);

    /**
     * 修改群成员信息
     *
     * @param req
     * @return
     */
    public ResponseVO updateGroupMember(UpdateGroupMemberReq req);

    /**
     * @param owner
     * @param groupId
     * @param appId
     * @return
     */
    public ResponseVO transferGroupMember(String owner, String groupId, Integer appId);

    /**
     * 禁言
     *
     * @param req
     * @return
     */
    public ResponseVO speak(SpeakMemberReq req);

}
