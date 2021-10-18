package com.practice.kafkacassandra.service;

import com.practice.kafkacassandra.entity.Advertisement;
import com.practice.kafkacassandra.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final AdvertisementRepository advertisementRepository;

    @KafkaListener(topics = "testTopic", groupId = "test_group_id")
    public void consume(Advertisement message) {
        log.info(String.format("Message received: %s", message));
        if(message != null) {
            message.setId(UUID.randomUUID());
            advertisementRepository.save(message);
        }
    }
}
