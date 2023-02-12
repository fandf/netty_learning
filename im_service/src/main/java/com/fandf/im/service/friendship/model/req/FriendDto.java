package com.fandf.im.service.friendship.model.req;

import lombok.Data;


/**
 * @author dongfengfan
 */
@Data
public class FriendDto {

    private String toId;

    private String remark;

    private String addSource;

    private String extra;
    /**
     * 附加信息
     */
    private String addWording;

}
