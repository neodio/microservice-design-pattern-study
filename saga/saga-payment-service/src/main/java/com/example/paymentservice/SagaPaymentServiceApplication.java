package com.example.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SagaPaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagaPaymentServiceApplication.class, args);
    }

}
