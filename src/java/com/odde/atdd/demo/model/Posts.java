package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class Posts {
    public void processAllPosts(final Consumer<Post> onEachPost) {

        new WordPressAdaptor().getAllPosts((Post post) -> {
            onEachPost.accept(post);
        });

    }
}
