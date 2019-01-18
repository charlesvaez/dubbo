package com.hgsoft.nacos.config.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

@Controller
@RequestMapping("config")
public class ConfigController {
   private static final String DATA_ID = "nacos-config";
   private static final String GROUP_ID = "DEFAULT_GROUP";

    //http://localhost:9099/config/get
    @NacosValue(value="${connectTimeoutInMills:5000}", autoRefreshed = true)
    private String connectTimeoutInMills;

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private String useLocalCache;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return connectTimeoutInMills;
    }

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    @NacosConfigListener(dataId=DATA_ID,groupId=GROUP_ID,timeout=2000)
    @ResponseBody
    public String get1() {
        System.out.println("useLocalCache: "+useLocalCache);
        return useLocalCache;
    }

    @RequestMapping(value = "/getConfig", method = RequestMethod.GET)
    @ResponseBody
    public String getConfig() {
        // 用以演示用，页面返回数据展示
        Map map = new HashMap();
        //  服务地址。本机演示故写localhost。请根据实际情况替换对应IP
        String serverAddr = "localhost";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);

        // 创建ConfigService，此处通过Properties方式进行创建，另一种演示serviceaddr获取configService.
        // 原理上都是通过 ConfigFactory.createConfigService()去进行创建
        ConfigService configService = null;
        String content = null;
        try {
            // ConfigService configService = NacosFactory.createConfigService(serverAddr);
            configService = NacosFactory.createConfigService(properties);
            content = configService.getConfig(DATA_ID, GROUP_ID, 5000);
            System.out.println("config : " + content);
            // 添加Listener，用以演示receive获取数据结果
            configService.addListener(DATA_ID, GROUP_ID, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("recieve : " + configInfo);
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });

            // 推送config,将原有dataid中信息替换。
//            boolean isPublishOk = configService.publishConfig(dataId, group, "publish config content");
//            System.out.println("isPublishOk : " + isPublishOk);
//            map.put("isPublishOk", isPublishOk);
//            Thread.sleep(3000);

//            content = configService.getConfig(dataId, group, 5000);
//            System.out.println("Thread sleep 3000ms : " + content);
//            map.put("Thread sleep 3000ms : ", content);

            // 删除指定dataid , group 配置
//            boolean isRemoveOk = configService.removeConfig(dataId, group);
//            System.out.println("remove " + dataId + "config is " + isRemoveOk);
//            Thread.sleep(3000);

//            content = configService.getConfig(dataId, group, 5000);
//            System.out.println("content after 5000ms "+content);


        } catch (NacosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return content;
    }

    public void setConnectTimeoutInMills(String connectTimeoutInMills) {
        this.connectTimeoutInMills = connectTimeoutInMills;
    }


}