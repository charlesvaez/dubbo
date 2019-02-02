package com.hgsoft.springboot.dubbo.anno.producer.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hgsoft.springboot.dubbo.api.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *http://127.0.0.1:9091/swagger-dubbo/api-docs
 * dubbo%3A%2F%2F192.168.183.1%3A20880%2Fcom.hgsoft.springboot.dubbo.api.service.DemoService%3Fanyhost%3Dtrue%26application%3Dspringboot-dubbo-anno-producer%26default.timeout%3D1000%26dubbo%3D2.6.2%26generic%3Dfalse%26interface%3Dcom.hgsoft.springboot.dubbo.api.service.DemoService%26logger%3Dslf4j%26methods%3DsayHello%26pid%3D13372%26revision%3D1.0.1%26side%3Dprovider%26timeout%3D5000%26timestamp%3D1549100613517%26version%3D1.0.1
 */
@Service(version = "${demo.service.version}",timeout = 5000)
@Api(value="Demo服务")
public class DemoServiceImpl implements DemoService {
    @Override
    @ApiOperation(value="sayHello方法",notes = "sayHello方法notes")
    public String sayHello(@ApiParam(name="name",value="姓名",required = true) String name) {
        System.out.println("=======================DemoServiceImpl=======================");
        return "Hello, " + name + " (from Spring Boot)";
    }
}
