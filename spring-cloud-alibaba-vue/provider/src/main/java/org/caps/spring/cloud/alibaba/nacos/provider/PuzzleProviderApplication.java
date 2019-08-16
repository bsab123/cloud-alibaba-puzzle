package org.caps.spring.cloud.alibaba.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PuzzleProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PuzzleProviderApplication.class, args);
    }
}