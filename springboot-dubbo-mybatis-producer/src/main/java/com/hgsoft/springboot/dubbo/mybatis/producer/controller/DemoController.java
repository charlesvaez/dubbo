package com.hgsoft.springboot.dubbo.mybatis.producer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.hgsoft.springboot.dubbo.mybatis.api.service.DemoService;
import com.hgsoft.springboot.dubbo.mybatis.common.entity.UserModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class DemoController {
    @Reference(version="${demo.service.version}",lazy=true,check=false)
    private DemoService demoService;

    //http://localhost:9091/user/findAllUsers
    @RequestMapping("/findAllUsers")
    public String findAllUsers(){
        System.out.println("================findAllUsers invoke=================");
       List<UserModel> users =  demoService.findAllUsers();
       return  JSON.toJSONString(users);
    }

    //http://localhost:9091/user/addUser/1
    @RequestMapping("/addUser/{id}")
    public String addUser(@PathVariable Long id){
        System.out.println("================addUser invoke=================");
        UserModel user = new UserModel();
        user.setId(id);
        user.setName("hcx");
        user.setPwd("123");
        user.setCreateTime(new Date());
        return  String.valueOf(demoService.addUser(user));
    }

    //http://localhost:9091/user/getUser/1
    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable Long id){
        System.out.println("================getUser invoke=================");
        UserModel user = demoService.getUser(id);
        return JSON.toJSONString(user);
    }

}
