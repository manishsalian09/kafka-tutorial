package org.trident.springkafkatutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.trident.springkafkatutorial.model.User;

import java.util.stream.IntStream;

@Service
public class MessageProducerService {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public void produce() {
        IntStream.range(0, 100)
                .forEach(i -> kafkaTemplate.send(topic, new User(i, String.format("%s-%d", "Manish", i))));
    }
}
