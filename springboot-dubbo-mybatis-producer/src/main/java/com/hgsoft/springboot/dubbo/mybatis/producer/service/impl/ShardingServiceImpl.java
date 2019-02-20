package com.hgsoft.springboot.dubbo.mybatis.producer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hgsoft.springboot.dubbo.mybatis.api.service.ShardingService;
import com.hgsoft.springboot.dubbo.mybatis.common.sharding.ShardingUserModel;
import com.hgsoft.springboot.dubbo.mybatis.producer.mapper.ShardingUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "${demo.service.version}")
public class ShardingServiceImpl implements ShardingService{
    @Autowired
    private ShardingUserMapper shardingUserMapper;

    @Override
    public List<ShardingUserModel> findAllUsers() {
        // 强制路由主库
//        HintManager.getInstance().setMasterRouteOnly();
        return shardingUserMapper.findAllUsers();
    }

    @Override
    public ShardingUserModel getUser(Long id) {
        return shardingUserMapper.getUser(id);
    }

    @Override
    public Long addUser(ShardingUserModel user) {
        return shardingUserMapper.addUser(user);
    }
}
