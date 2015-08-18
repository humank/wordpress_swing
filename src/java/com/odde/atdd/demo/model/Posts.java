package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class Posts {
    public void processAllPosts(final Consumer<Post> onEachPost) {
        Credential admin = CredentialFactory.createAdmin();

        new WordPressAdaptor().getAllPosts(admin, (Post post) -> {
            onEachPost.accept(post);
        });
    }
}
