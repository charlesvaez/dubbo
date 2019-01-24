package com.hgsoft.nacos.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "nacos-config", autoRefreshed = true)
@EnableDubbo
public class NacosDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDubboConsumerApplication.class, args);
    }

}

