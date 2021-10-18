package com.practice.kafkacassandrafe.service;

import com.practice.kafkacassandrafe.entity.Advertisement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String TOPIC = "testTopic";

    public void sendMessage(String message, String author) {
        log.info(String.format("Message Sending: %s %s", message, author));

        Advertisement advertisement = new Advertisement();
        advertisement.setId(UUID.randomUUID());
        advertisement.setAuthor(author);
        advertisement.setText(message);

        ListenableFuture<SendResult<String, Object>> future = this.kafkaTemplate.send(TOPIC, advertisement);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
            }
        });
    }
}
