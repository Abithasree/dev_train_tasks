package com.example.asmtest.controller;

import com.example.asmtest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping("/save")
    public String save(@RequestBody RedisRequest request) {
        return redisService.save(request.getKey(), request.getValue(), request.getExpiry());
    }

    @PostMapping("/get")
    public Object get(@RequestBody RedisKeyRequest request) {
        return redisService.get(request.getKey());
    }
}
