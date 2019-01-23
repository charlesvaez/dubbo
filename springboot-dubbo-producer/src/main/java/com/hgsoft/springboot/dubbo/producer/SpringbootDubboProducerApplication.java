package com.hgsoft.springboot.dubbo.producer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
//@EnableSwagger2
public class SpringbootDubboProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboProducerApplication.class, args);
    }

}

