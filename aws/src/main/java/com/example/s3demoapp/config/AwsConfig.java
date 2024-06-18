package com.example.s3demoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfig {

    @Bean
    public S3Client s3Client() {
        AwsSessionCredentials sessionCreds = AwsSessionCredentials.create(
                "XXXXXXXXXXX",
                "XXXXXXXXXXXXX",
                "XXXXSESSION_KEYXXX");

        return S3Client.builder()
                .region(Region.US_WEST_2)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCreds))
                .build();
    }
}
