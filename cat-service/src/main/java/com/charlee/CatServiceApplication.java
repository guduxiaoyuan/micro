package com.charlee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.openfeign.EnableFeignClients;

import tk.mybatis.spring.annotation.MapperScan;

//@EnableEurekaClient
//@EnableHystrix
//@EnableFeignClients
@SpringBootApplication
@MapperScan({"com.charlee.*"})
public class CatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatServiceApplication.class, args);
    }
}
