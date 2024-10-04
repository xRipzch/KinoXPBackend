package com.example.kinoxpbackend.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RestTemplate {
        @Bean
        public org.springframework.web.client.RestTemplate restTemplate(RestTemplateBuilder builder) {
            System.out.println("Building a rest");
            return builder.build();
        }
    }
