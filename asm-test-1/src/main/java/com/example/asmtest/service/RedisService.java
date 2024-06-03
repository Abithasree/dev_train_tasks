package com.example.asmtest.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;


    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String save(String key, String value, Long expiry) {
        try {
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            if (expiry != null) {
                valueOperations.set(key, value, Duration.ofSeconds(expiry));
            } else {
                valueOperations.set(key, value);
            }
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
    }

    public Object get(String key) {
        try {
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            return valueOperations.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
