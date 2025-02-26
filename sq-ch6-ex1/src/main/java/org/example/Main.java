package org.example;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);

        var comment = new Comment();
        comment.setAuthor("Jorge");
        comment.setText("this is an important message for Peppa Pig, please read it immediately!");

        service.publishComment(comment);
    }
}