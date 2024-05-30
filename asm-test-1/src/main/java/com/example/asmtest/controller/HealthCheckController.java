package com.example.asmtest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/securin")
public class HealthCheckController {
	

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/currentTime")
    public ResponseEntity<String> currentTime() {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        return ResponseEntity.ok(currentTime);
    }
}
