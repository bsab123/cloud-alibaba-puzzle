package org.caps.spring.cloud.alibaba.nacos.consumer.feign.service.fallback;
import org.caps.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String message) {
        return "熔断触发！";
    }
}