package com.example.asmtest.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "specificTopic", groupId = "group_id",autoStartup = "${listen.auto.start:true}", concurrency = "${listen.concurrency:3}")
    public void listen(String message) {
        messages.add(message);
        System.out.println("Hi Abitha, I received message: \"" + message + "\"");
    }

    public List<String> getMessages(String topic, int count) {
        // Here, we assume all messages are from the specified topic
        List<String> result = new ArrayList<>();
        for (int i = 0; i < count && i < messages.size(); i++) {
            result.add(messages.get(i));
        }
        return result;
    }
}
