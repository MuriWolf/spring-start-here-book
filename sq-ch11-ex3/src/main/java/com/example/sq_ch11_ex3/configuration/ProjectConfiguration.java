package com.example.sq_ch11_ex3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
