package com.example.demo.service.impl;

import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Service
public class RabbitMQMessageServiceImpl implements MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMessage(String message) {
        rabbitTemplate.convertAndSend("spring-rabbit-queue", message);
        return "Message Sent";
    }
}
