package com.hzit.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HzUploadService {
    public static void main(String[] args) {
        SpringApplication.run(HzUploadService.class, args);

    }
}
