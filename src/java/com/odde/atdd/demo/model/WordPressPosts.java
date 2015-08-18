package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class WordPressPosts implements Posts {
    private final WordPressAdaptor wordPressAdaptor;

    public WordPressPosts(WordPressAdaptor wordPressAdaptor) {
        this.wordPressAdaptor = wordPressAdaptor;
    }

    public void processAllPosts(final Consumer<Post> onEachPost) {
        wordPressAdaptor.getAllPosts(CredentialFactory.createAdmin(), (Post post) -> {
            onEachPost.accept(post);
        });
    }

    @Override
    public void comment(Post post, String comment) {
        wordPressAdaptor.comment(CredentialFactory.current(), post, comment);
    }
}
