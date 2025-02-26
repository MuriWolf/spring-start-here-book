package main;

import config.ProjectConfig;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var parrot01 = new Parrot();
        parrot01.setName("Omae");

        var parrot02 = new Parrot();
        parrot02.setName("Jojo");

//        Supplier<Parrot> parrotSupplier = () -> parrot01;

        int random1 = (int) (Math.random() * 100); // 1 - 100
        int random2 = (int) (Math.random() * 100); // 1 - 100

        if (random1 > 50) {
            context.registerBean("parrot1", Parrot.class, () -> parrot01);
        }
        if (random2 > 50) {
            context.registerBean("parrot2", Parrot.class, () -> parrot02, bc -> bc.setPrimary(true));
        }

        if (context.containsBean("parrot1")) {
            Parrot parrot01Return = context.getBean("parrot1", Parrot.class);
            System.out.println(parrot01Return.getName());
        }

        if (context.containsBean("parrot2")) {
            Parrot parrot02Return = context.getBean("parrot2", Parrot.class);
            System.out.println(parrot02Return.getName());
        }
    }
}
