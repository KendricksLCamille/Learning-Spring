package com.learning.consuming_a_restful_web_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConRestfulWebService {
    private static final Logger log = LoggerFactory.getLogger(ConRestfulWebService.class);

    public static void main(String[] args) {
        SpringApplication.run(ConRestfulWebService.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            var quote = restTemplate.getForObject(
                    "https://jsonplaceholder.typicode.com/todos/1", Value.class);
            log.info(quote.toString());
        };
    }
}
