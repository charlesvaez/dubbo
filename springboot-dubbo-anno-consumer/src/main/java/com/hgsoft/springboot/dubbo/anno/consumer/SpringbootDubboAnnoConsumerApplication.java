package com.hgsoft.springboot.dubbo.anno.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.hgsoft.springboot.dubbo.anno.consumer")
public class SpringbootDubboAnnoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboAnnoConsumerApplication.class, args);
    }

}

