package com.fandf.im.common.enums;

/**
 * 添加好友验证
 * @author dongfengfan
 */

public enum AllowFriendTypeEnum {

    /**
     * 验证
     */
    NEED(2),

    /**
     * 不需要验证
     */
    NOT_NEED(1),

    ;


    private int code;

    AllowFriendTypeEnum(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}