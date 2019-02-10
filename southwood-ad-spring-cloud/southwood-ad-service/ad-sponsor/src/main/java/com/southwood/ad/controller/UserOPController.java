package com.southwood.ad.controller;

import com.alibaba.fastjson.JSON;
import com.southwood.ad.exception.AdException;
import com.southwood.ad.service.IUserService;
import com.southwood.ad.vo.CreateUserRequest;
import com.southwood.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nanzhao on 2019/2/10 5:23 PM
 */
@Slf4j
@RestController  //json格式数据返回
public class UserOPController {

    private final IUserService userService;

    @Autowired
    public UserOPController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public CreateUserResponse createUser(
            @RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor: createUser -> {}",
                JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
