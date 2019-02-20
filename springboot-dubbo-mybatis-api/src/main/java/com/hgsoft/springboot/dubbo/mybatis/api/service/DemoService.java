package com.hgsoft.springboot.dubbo.mybatis.api.service;

import com.hgsoft.springboot.dubbo.mybatis.common.entity.UserModel;

import java.util.List;

/**
 * DemoService
 * 服务Api接口类
 * @author hcx
 * @date 2019/1/16
 */
public interface DemoService {
    Boolean addUser(UserModel user);

    List<UserModel> findAllUsers();

    UserModel getUser(Long id);

}