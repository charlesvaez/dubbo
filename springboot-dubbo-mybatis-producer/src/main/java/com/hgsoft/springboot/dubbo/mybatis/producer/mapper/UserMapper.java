package com.hgsoft.springboot.dubbo.mybatis.producer.mapper;

import com.hgsoft.springboot.dubbo.mybatis.common.entity.UserModel;

import java.util.List;

public interface UserMapper {
    List<UserModel> findAllUsers();
    UserModel getUser(Long id);
    void addUser(UserModel user);
}
