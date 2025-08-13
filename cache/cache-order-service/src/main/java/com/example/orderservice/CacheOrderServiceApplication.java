package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheOrderServiceApplication.class, args);
    }

}
