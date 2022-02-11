package com.cognizant.consumer.services;

import com.cognizant.consumer.configuration.KafkaConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = KafkaConfig.TOPIC, groupId = KafkaConfig.GROUP_ID)
    public void listen(String message) {
        System.out.println(message);
    }
}
