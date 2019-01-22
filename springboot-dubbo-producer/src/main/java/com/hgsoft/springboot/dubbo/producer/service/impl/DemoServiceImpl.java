package com.hgsoft.springboot.dubbo.producer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hgsoft.springboot.dubbo.api.service.DemoService;

/**
 *
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("=======================DemoServiceImpl=======================");
        return "Hello, " + name + " (from Spring Boot)";
    }
}
