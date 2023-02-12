package com.fandf.im.common.model;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 客户端信息
 * @author fandongfeng
 **/
@Data
@NoArgsConstructor
public class ClientInfo {

    private Integer appId;

    private Integer clientType;

    private String imei;

}
