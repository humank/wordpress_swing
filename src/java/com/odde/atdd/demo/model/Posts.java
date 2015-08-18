package com.odde.atdd.demo.model;

import java.util.function.Consumer;

public interface Posts {
    void processAllPosts(Consumer<Post> onEachPost);
    void comment(Post post, String comment);
}
