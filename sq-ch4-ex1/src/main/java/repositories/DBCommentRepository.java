package repositories;

import models.Comment;

public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing in the database: "+ comment.getText());
    }
}
