package com.practice.kafkacassandrafe.controller;


import com.practice.kafkacassandrafe.entity.Advertisement;
import com.practice.kafkacassandrafe.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class TestController {

    private final KafkaProducerService kafkaProducerService;

    @Value("${beUrl}")
    private String beUrl;

    @PostMapping("/test")
    public void test(@RequestParam("message") String message, @RequestParam("author") String author){
        kafkaProducerService.sendMessage(message, author);
    }

    @GetMapping("/findAll")
    public List<Advertisement> findAll() {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<List<Advertisement>> response = restTemplate.exchange(
                beUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Advertisement>>(){});
        return response.getBody();
    }
}
