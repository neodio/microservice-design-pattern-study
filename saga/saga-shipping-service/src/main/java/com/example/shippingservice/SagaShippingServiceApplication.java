package com.example.shippingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SagaShippingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagaShippingServiceApplication.class, args);
    }

}
