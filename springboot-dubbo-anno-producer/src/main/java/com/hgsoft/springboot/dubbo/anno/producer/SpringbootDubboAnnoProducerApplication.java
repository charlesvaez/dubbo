package com.hgsoft.springboot.dubbo.anno.producer;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.hgsoft.springboot.dubbo.anno.producer.impl")
public class SpringbootDubboAnnoProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboAnnoProducerApplication.class, args);


//        Main.main(args);
    }

}

