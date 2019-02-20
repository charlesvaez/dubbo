package com.hgsoft.springboot.dubbo.mybatis.producer.mapper;

import com.hgsoft.springboot.dubbo.mybatis.common.sharding.ShardingUserModel;

import java.util.List;

public interface ShardingUserMapper {
    List<ShardingUserModel> findAllUsers();
    ShardingUserModel getUser(Long id);
    Long addUser(ShardingUserModel user);
}
