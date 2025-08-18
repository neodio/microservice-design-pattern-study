package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class DeploymentOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeploymentOrderServiceApplication.class, args);
    }

}
