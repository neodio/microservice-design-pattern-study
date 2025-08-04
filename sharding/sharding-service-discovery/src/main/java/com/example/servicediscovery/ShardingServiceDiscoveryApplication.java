package com.example.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShardingServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingServiceDiscoveryApplication.class, args);
    }

}
