package com.odde.atdd.demo.model;

import java.util.function.Consumer;

public interface Post {
    String getTitle();

    Integer getId();

    void letEachComment(Consumer<Comment> onEachComment);

    void addComment(String comment);

    String getContent();

    void allowToCommentOrNot(Runnable yes, Runnable no);
}
