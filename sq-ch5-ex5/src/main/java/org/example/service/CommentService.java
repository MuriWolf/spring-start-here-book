package org.example.service;

public class CommentService {
    private String author;
    private String text;

    @Override
    public String toString() {
        return "CommentService{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
