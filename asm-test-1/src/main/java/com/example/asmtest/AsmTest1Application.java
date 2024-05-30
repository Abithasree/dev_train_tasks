package com.example.asmtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.asmtest.config", "com.example.asmtest.repository", "com.example.asmtest.controller", "com.example.asmtest.service"})
@EntityScan("com.example.asmtest.entity") 
public class AsmTest1Application {
    public static void main(String[] args) {
        SpringApplication.run(AsmTest1Application.class, args);
    }
}
