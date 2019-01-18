package com.hgsoft.nacos.dubbo.producer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hgsoft.springboot.dubbo.api.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {
    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Override
    public String sayHello(String name) {
        log.info("=================sayHello====================");
        return "Hello, " + name + " (from Spring Boot)";
    }
}
