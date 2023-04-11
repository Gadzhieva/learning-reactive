package com.gadzhieva.learningreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/message/{text}")
    public Mono<String> getMessage(@PathVariable("text") String text) {
        Mono<String> message = webClientBuilder.build()
                .get()
                .uri("http://learning-service/get/" + text)
                .retrieve()
                .bodyToMono(String.class);

        return message;
    }
}
