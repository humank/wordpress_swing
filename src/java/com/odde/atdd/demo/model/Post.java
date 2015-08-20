package com.odde.atdd.demo.model;

import java.util.function.Consumer;

public interface Post {
    String getTitle();

    Integer getId();

    void processAllComments(Consumer<Comment> onEachComment);

    void addComment(String comment);

    String getContent();

    void allowToComment(Runnable yes, Runnable no);
}
