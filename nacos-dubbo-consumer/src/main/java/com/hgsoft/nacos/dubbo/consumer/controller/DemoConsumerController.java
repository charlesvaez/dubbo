package com.hgsoft.nacos.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.hgsoft.springboot.dubbo.api.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
//@ConfigurationProperties
public class DemoConsumerController {
    private final static Logger LOG = LoggerFactory.getLogger(DemoConsumerController.class);

    @NacosValue(value="${dubbo.consumer.group}",autoRefreshed = true)
    private String serviceGroup;

    //http://localhost:9091/sayHello/hcx
    @Reference(version = "${demo.service.version}",group="${dubbo.consumer.group}")
    private DemoService demoService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        LOG.debug("===========================================");
        LOG.info("sayHello {},{}",this,serviceGroup);
        return demoService.sayHello(name);
    }

}
