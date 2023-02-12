package com.fandf.im.common.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 公共请求类
 * @author dongfengfan
 */
@Data
public class RequestBase {
    @NotNull(message = "appId不能为空")
    private Integer appId;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 客户端类型
     */
    private Integer clientType;
    /**
     * 设备唯一码
     */
    private String imei;
}
