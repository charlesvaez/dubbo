package com.hgsoft.springboot.dubbo.mybatis.producer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.hgsoft.springboot.dubbo.mybatis.producer.mapper")
public class SpringbootDubboMybatisProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboMybatisProducerApplication.class, args);
    }

}

