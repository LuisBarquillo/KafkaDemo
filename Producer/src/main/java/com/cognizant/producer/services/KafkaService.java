package com.cognizant.producer.services;

public interface KafkaService {
    void sendMessage(String message);
}
