package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EdaOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdaOrderServiceApplication.class, args);
    }

}
