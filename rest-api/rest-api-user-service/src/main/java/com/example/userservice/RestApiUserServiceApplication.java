package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class RestApiUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiUserServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        int TIMEOUT = 5000;

        RestTemplate restTemplate = new RestTemplateBuilder()
                .connectTimeout(Duration.ofMillis(TIMEOUT))
                .readTimeout(Duration.ofMillis(TIMEOUT))
                .build();

        return restTemplate;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
