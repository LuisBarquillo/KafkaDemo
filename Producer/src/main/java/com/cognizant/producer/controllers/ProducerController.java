package com.cognizant.producer.controllers;

import com.cognizant.producer.services.KafkaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private final KafkaService kafkaService;

    public ProducerController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        kafkaService.sendMessage(message);
    }
}
