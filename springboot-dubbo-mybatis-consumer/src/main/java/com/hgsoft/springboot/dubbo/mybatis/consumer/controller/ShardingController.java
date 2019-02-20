package com.hgsoft.springboot.dubbo.mybatis.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.hgsoft.springboot.dubbo.mybatis.api.service.ShardingService;
import com.hgsoft.springboot.dubbo.mybatis.common.entity.UserModel;
import com.hgsoft.springboot.dubbo.mybatis.common.sharding.ShardingUserModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sharding")
public class ShardingController {
    @Reference(version="${demo.service.version}",lazy=true,check=false)
    private ShardingService shardingService;

    //http://localhost:9092/sharding/findAllUsers
    @RequestMapping("/findAllUsers")
    public String findAllUsers(){
        System.out.println("================findAllUsers invoke=================");
        List<ShardingUserModel> users =  shardingService.findAllUsers();
        return  JSON.toJSONString(users);
    }

    //http://localhost:9092/sharding/addUser/1
    @RequestMapping("/addUser/{id}")
    public String addUser(@PathVariable Long id){
        System.out.println("================addUser invoke=================");
        ShardingUserModel user = new ShardingUserModel();
        user.setId(id);
        user.setName("hcx");
        user.setPwd("123");
        user.setCreateTime(new Date());
        return  String.valueOf(shardingService.addUser(user));
    }

    //http://localhost:9092/sharding/getUser/1
    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable Long id){
        System.out.println("================getUser invoke=================");
        UserModel user = shardingService.getUser(id);
        return JSON.toJSONString(user);
    }

}
