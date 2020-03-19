package com.wufan.hello.spring.cloud.alibaba.nacos.consumer.feign.controller;

import com.wufan.hello.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController {

    @Qualifier("echoServiceFallback")
    @Autowired
    private NacosProviderService nacosProviderService;

    @GetMapping(value = "/echo")
    public String echo(){
        return nacosProviderService.echo("Hello Feign");
    }
}
