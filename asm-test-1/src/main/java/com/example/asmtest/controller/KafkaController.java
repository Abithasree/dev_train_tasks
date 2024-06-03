package com.example.asmtest.controller;

import com.example.asmtest.service.KafkaProducerService;
import com.example.asmtest.service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaConsumerService kafkaConsumerService;

    @Autowired
    public KafkaController(KafkaProducerService kafkaProducerService, KafkaConsumerService kafkaConsumerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody KafkaRequest request) {
        return kafkaProducerService.sendMessage(request.getTopic(), request.getMessage());
    }

    @PostMapping("/fetch")
    public List<String> fetchMessages(@RequestBody KafkaFetchRequest request) {
        return kafkaConsumerService.getMessages(request.getTopic(), request.getCount());
    }
}
