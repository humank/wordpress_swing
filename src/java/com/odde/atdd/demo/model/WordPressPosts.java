package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class WordPressPosts implements Posts {
    private final WordPressAdaptor wordPressAdaptor;

    public WordPressPosts(WordPressAdaptor wordPressAdaptor) {
        this.wordPressAdaptor = wordPressAdaptor;
    }

    public void letEachPost(final Consumer<Post> onEachPost) {
        wordPressAdaptor.letEachPost(CredentialFactory.createAdmin(), post -> onEachPost.accept(post));
    }

}
