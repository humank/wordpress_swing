package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class Post {
    public final String title;
    public final Integer id;

    public Post(String title, Integer id) {
        this.title = title;
        this.id = id;
    }

    public void processAllComments(Consumer<Comment> onEachComment) {
        new WordPressAdaptor().getAllComments(CredentialFactory.createAdmin(), this, onEachComment);
    }
}
