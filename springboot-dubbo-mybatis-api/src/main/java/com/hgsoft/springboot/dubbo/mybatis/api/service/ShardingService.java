package com.hgsoft.springboot.dubbo.mybatis.api.service;

import com.hgsoft.springboot.dubbo.mybatis.common.sharding.ShardingUserModel;

import java.util.List;

public interface ShardingService {
    List<ShardingUserModel> findAllUsers();

    ShardingUserModel getUser(Long id);

    Long addUser(ShardingUserModel user);
}