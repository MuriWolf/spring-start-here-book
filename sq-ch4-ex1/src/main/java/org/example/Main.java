package org.example;

import models.Comment;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var commentRepository = new DBCommentRepository();
        var emailCommentNotificationProxy = new EmailCommentNotificationProxy();

        var commentService = new CommentService(emailCommentNotificationProxy, commentRepository);

        var comment = new Comment("this is a small text.", "Junior");
        commentService.publishComment(comment);
    }
}