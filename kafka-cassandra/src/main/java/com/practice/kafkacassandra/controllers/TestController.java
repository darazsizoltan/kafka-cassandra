package com.practice.kafkacassandra.controllers;

import com.practice.kafkacassandra.entity.Advertisement;
import com.practice.kafkacassandra.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class TestController {

    private final AdvertisementService advertisementService;

    @GetMapping("/findAll")
    public List<Advertisement> findAll() {
        return advertisementService.findAll();
    }
}
