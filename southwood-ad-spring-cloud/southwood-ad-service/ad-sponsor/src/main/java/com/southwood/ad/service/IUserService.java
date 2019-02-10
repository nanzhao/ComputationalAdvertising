package com.southwood.ad.service;

import com.southwood.ad.exception.AdException;
import com.southwood.ad.vo.CreateUserRequest;
import com.southwood.ad.vo.CreateUserResponse;

/**
 * Created by nanzhao on 2019/2/10 3:55 PM
 */
public interface IUserService {
    /**
     * <h2>创建用户</h2>
     * */
    CreateUserResponse createUser(CreateUserRequest request)
            throws AdException;
}
