package com.hgsoft.springboot.dubbo.producer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hgsoft.springboot.dubbo.api.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *
 */
@Service(version = "${demo.service.version}")
@Api(value="Demo服务")
public class DemoServiceImpl implements DemoService {
    @Override
    @ApiOperation(value="sayHello方法",notes = "sayHello方法notes")
    public String sayHello(@ApiParam(name="name",value="姓名",required = true) String name) {
        System.out.println("=======================DemoServiceImpl=======================");
        return "Hello, " + name + " (from Spring Boot)";
    }
}
