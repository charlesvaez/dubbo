package com.hgsoft.springboot.dubbo.anno.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hgsoft.springboot.dubbo.api.service.DemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoConsumerController
 * 消费者控制层
 * @author hcx
 * @date 2018/1/16
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return demoService.sayHello(name);
    }

}
