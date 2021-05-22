package org.trident.springkafkatutorial.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.trident.springkafkatutorial.model.User;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${kafka.bootstrap.address}")
    private String bootstrapAddress;

    @Bean
    public ConsumerFactory<String, User> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                Map.of(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress),
                new StringDeserializer(),
                new JsonDeserializer<>(User.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> kafkaListenerContainerFactory() {
        var concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, User>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
        return concurrentKafkaListenerContainerFactory;
    }
}
