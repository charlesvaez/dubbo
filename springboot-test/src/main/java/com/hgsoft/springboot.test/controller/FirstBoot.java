package com.hgsoft.springboot.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "SpringBoot HelloWorld")
public class FirstBoot {
    //http://127.0.0.1:8881/swagger-ui.html

    //http://127.0.0.1:8881/v2/api-docs
    @ApiOperation(value="测试方式")
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String testFirstMethod(){
        return "Hello jigang!!!";
    }

}
