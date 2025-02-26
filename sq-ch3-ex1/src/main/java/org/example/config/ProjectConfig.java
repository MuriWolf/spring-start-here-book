package org.example.config;

import org.example.Parrot;
import org.example.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
public class ProjectConfig {

    @Bean
    public Person person() {
        var person = new Person();
        person.setName("Jao");
        return person;
    }

    @Bean
    public Parrot parrot() {
        var parrot = new Parrot();
        parrot.setName("Hihi");
        return parrot;
    }
}
