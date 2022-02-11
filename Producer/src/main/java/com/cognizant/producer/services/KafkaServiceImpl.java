package com.cognizant.producer.services;

import com.cognizant.producer.configuration.KafkaConfig;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaServiceImpl implements KafkaService {
    private final KafkaTemplate kafkaTemplate;

    public KafkaServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(KafkaConfig.TOPIC, message).addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                LogFactory.getLog(KafkaServiceImpl.class).error("---> Failed sending message to Kafka");
            }

            @Override
            public void onSuccess(Object o) {
                LogFactory.getLog(KafkaServiceImpl.class).info("---> Message sent to Kafka successfully");
            }
        });
    }
}
