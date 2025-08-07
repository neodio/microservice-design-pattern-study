package com.example.shippingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EdaShippingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdaShippingServiceApplication.class, args);
    }

}
