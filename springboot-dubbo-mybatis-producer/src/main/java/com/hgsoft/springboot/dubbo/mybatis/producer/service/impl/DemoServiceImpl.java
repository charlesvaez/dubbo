package com.hgsoft.springboot.dubbo.mybatis.producer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hgsoft.springboot.dubbo.mybatis.api.service.DemoService;
import com.hgsoft.springboot.dubbo.mybatis.common.entity.UserModel;
import com.hgsoft.springboot.dubbo.mybatis.producer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean addUser(UserModel user) {
        if(null != user){
            userMapper.addUser(user);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<UserModel> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public UserModel getUser(Long id) {
        if(null == id){
            return null;
        }
        return userMapper.getUser(id);
    }
}
