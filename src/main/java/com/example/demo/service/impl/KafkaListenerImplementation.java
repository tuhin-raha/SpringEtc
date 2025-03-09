package com.example.demo.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerImplementation {

    @KafkaListener(topics = "spring-topic", groupId = "my-group")
    public void listenMessage(String message) {
        System.out.println("Received Message: " + message);
    }

}
