package org.example;

import org.example.config.ProjectConfig;
import org.example.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService c1 = context.getBean("commentService", CommentService.class);
        CommentService c2 = context.getBean("commentService", CommentService.class);

        boolean b = c1 == c2;

        System.out.println("is instances equal: " + b);

    }
}