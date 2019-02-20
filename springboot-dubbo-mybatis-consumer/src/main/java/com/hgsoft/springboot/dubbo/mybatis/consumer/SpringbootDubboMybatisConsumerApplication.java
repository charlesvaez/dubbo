package com.hgsoft.springboot.dubbo.mybatis.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class SpringbootDubboMybatisConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboMybatisConsumerApplication.class, args);
    }

}
