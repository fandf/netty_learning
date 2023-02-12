package com.fandf.im.common.model;

import lombok.Data;

/**
 * 客户端dto
 * @author dongfengfan
 */
@Data
public class UserClientDto {

    private Integer appId;

    private Integer clientType;

    private String userId;

    private String imei;

}
