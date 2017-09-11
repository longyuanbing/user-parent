package com.yuandu.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages="com.yuandu.user.dao.mapper")
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}