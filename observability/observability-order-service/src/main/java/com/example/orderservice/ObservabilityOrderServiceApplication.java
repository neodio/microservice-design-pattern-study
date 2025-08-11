package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ObservabilityOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObservabilityOrderServiceApplication.class, args);
    }

}
