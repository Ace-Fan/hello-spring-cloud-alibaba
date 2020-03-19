package com.wufan.hello.spring.cloud.alibaba.nacos.consumer.feign.service;

import com.wufan.hello.spring.cloud.alibaba.nacos.consumer.feign.service.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider",fallback = EchoServiceFallback.class)
public interface NacosProviderService {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable(value = "message") String message);
}
