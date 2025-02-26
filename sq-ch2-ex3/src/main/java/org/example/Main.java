package org.example;
import org.example.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Parrot parrot1 = context.getBean("koko", Parrot.class);
        System.out.println(parrot1.getName());
    }
}