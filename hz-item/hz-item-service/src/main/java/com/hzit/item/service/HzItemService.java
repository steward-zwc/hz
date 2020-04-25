package com.hzit.item.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hzit.item.service.mapper")
public class HzItemService {
    public static void main(String[] args) {
        SpringApplication.run(HzItemService.class, args);
    }
}
