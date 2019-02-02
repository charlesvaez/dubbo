package com.hgsoft.springboot.dubbo.anno.producer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfiguration {
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("springboot-dubbo-anno-producer");
        applicationConfig.setLogger("slf4j");
        return applicationConfig;
    }
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        registryConfig.setClient("curator");
        registryConfig.setProtocol("dubbo");
        return registryConfig;
    }
    @Bean
    public ProviderConfig providerConfig(){
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(100);//设置超时时间
        providerConfig.setRetries(2);//设置重试次数
        providerConfig.setLoadbalance("roundrobin");
        providerConfig.setConnections(10);
        return providerConfig;
    }
}
