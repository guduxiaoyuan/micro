package com.charlee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableHystrix
@EnableFeignClients("com.charlee")
@SpringBootApplication
public class DogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogServiceApplication.class, args);
    }
}
