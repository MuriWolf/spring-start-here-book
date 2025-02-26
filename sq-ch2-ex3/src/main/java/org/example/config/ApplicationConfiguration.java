package org.example.config;

import org.example.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    Parrot parrot1() {
        var parrot = new Parrot();
        parrot.setName("Claire");
        return parrot;
    }

    @Bean("koko")
    Parrot parrot2() {
        var parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }
}
