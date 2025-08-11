package com.example.apigatewayservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bff")
@Slf4j
public class BffController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public BffController(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    // 회원 가입 (User-Service 호출)
    @PostMapping("/signup")
    public Mono<String> signup(@RequestBody Map<String, Object> user) {
        log.info("signup method called");
        return loadBalancedWebClientBuilder.build()
                .post()
                .uri("http://user-service/users")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(String.class);
    }

    // 로그인 (User-Service 호출)
    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody Map<String, Object> credentials) {
        log.info("login method called");
        return loadBalancedWebClientBuilder.build()
                .post()
                .uri("http://user-service/login")
                .bodyValue(credentials)
                .retrieve()
                .toEntity(String.class)
                .map(clientResponse -> {
                    String body = clientResponse.getBody();
                    String customHeader = clientResponse.getHeaders().getFirst("Token");

                    return ResponseEntity
                            .ok()
                            .header("Token", customHeader != null ? customHeader : "N/A")
                            .body(body);
                });
    }

    // 전체 회원 목록 조회 (User-Service 호출)
    @GetMapping("/users")
    public Mono<List<Object>> getAllUsers() {
        log.info("getAllUsers method called");
        return loadBalancedWebClientBuilder.build()
                .get()
                .uri("http://user-service/users")
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList();
    }

    // 회원 상세 조회 (User-Service 호출)
    @GetMapping("/users/{userId}")
    public Mono<List<Object>> getUser(@PathVariable String userId) {
        log.info("getUser method called");
        return loadBalancedWebClientBuilder.build()
            .get()
            .uri("http://user-service/users/{userId}", userId)
            .retrieve()
            .bodyToFlux(Object.class)
            .collectList();
    }

    // 주문하기 (Order-Service 호출)
    @PostMapping("/orders/{userId}")
    public Mono<String> createOrder(@PathVariable String userId, @RequestBody Map<String, Object> orderRequest) {
        log.info("createOrder method called");
        return loadBalancedWebClientBuilder.build()
            .post()
            .uri("http://order-service/{userId}/orders", userId)
            .bodyValue(orderRequest)
            .retrieve()
            .bodyToMono(String.class);
    }

    // 주문 목록 확인 (Order-Service 호출)
    @GetMapping("/orders/{userId}")
    public Mono<List<Object>> getOrders(@PathVariable String userId) {
        return loadBalancedWebClientBuilder.build()
                .get()
                .uri("http://order-service/{userId}/orders", userId)
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList();
    }
}