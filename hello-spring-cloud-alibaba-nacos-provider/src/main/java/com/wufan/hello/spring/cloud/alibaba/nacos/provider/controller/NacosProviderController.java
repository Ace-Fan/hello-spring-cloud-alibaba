package com.wufan.hello.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable(value = "message") String message){
        return "Hello Nacos " +message +" I am from " +port;
    }

    @GetMapping(value = "/hi")
    public String hi(){
        String name = applicationContext.getEnvironment().getProperty("user.name");
        return name;
    }
}
