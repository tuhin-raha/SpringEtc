package com.example.demo.service.impl;

import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageServiceImpl implements MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public String sendMessage(String message) {
        kafkaTemplate.send("spring-topic", message);
        return "Message Sent";
    }
}
