package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class WordPressPost implements Post {

    private final WordPressAdaptor wordPressAdaptor;
    private final String content;
    private final boolean isAllowedToComment;

    @Override
    public String getTitle() {
        return title;
    }

    private final String title;

    @Override
    public Integer getId() {
        return id;
    }

    private final Integer id;

    public WordPressPost(String title, Integer id, WordPressAdaptor wordPressAdaptor, String content, boolean isAllowedToComment) {
        this.title = title;
        this.id = id;
        this.wordPressAdaptor = wordPressAdaptor;
        this.content = content;
        this.isAllowedToComment = isAllowedToComment;
    }

    @Override
    public void processAllComments(Consumer<Comment> onEachComment) {
        wordPressAdaptor.getAllComments(CredentialFactory.createAdmin(), this, onEachComment);
    }

    @Override
    public void addComment(String comment) {
        wordPressAdaptor.comment(CredentialFactory.current(), this, comment);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void allowToComment(Runnable yes, Runnable no) {
        if (isAllowedToComment)
            yes.run();
        else
            no.run();
    }
}
