package org.trident.springkafkatutorial.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.trident.springkafkatutorial.model.User;

@Service
public class MessageConsumerService {

    @Value("${kafka.topic}")
    private String topic;

    @KafkaListener(topics = "message-broker", groupId = "0", containerFactory = "kafkaListenerContainerFactory")
    public void consume(User user) {
        System.out.println(user);
    }
}
