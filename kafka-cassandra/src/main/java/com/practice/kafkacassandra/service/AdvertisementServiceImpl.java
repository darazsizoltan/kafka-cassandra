package com.practice.kafkacassandra.service;

import com.practice.kafkacassandra.entity.Advertisement;
import com.practice.kafkacassandra.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    @Override
    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }
}
