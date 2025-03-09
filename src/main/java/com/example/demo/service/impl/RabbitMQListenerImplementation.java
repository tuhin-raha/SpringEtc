package com.example.demo.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListenerImplementation {

    @RabbitListener(queues = "spring-rabbit-queue")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
