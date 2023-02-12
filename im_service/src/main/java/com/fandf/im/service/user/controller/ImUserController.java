package com.fandf.im.service.user.controller;

import com.fandf.im.common.ResponseVO;
import com.fandf.im.service.user.model.req.ImportUserReq;
import com.fandf.im.service.user.service.ImUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fandongfeng
 * @date 2023/2/11 21:19
 */
@RestController
@RequestMapping("v1/user")
public class ImUserController {

    @Resource
    ImUserService imUserService;

    @PostMapping("importUser")
    public ResponseVO importUser(@RequestBody ImportUserReq req) {
        return imUserService.importUser(req);
    }

//    @RequestMapping("/deleteUser")
//    public ResponseVO deleteUser(@RequestBody @Validated DeleteUserReq req, Integer appId) {
//        req.setAppId(appId);
//        return imUserService.deleteUser(req);
//    }
}
