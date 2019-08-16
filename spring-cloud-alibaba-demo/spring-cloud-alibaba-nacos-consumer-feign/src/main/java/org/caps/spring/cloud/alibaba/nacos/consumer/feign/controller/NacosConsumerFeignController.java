package org.caps.spring.cloud.alibaba.nacos.consumer.feign.controller;

import org.caps.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosConsumerFeignController {

    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/echo/feign/consumer")
    public String echo() {
        return echoService.echo("nacos-feign-consumer");
    }
}