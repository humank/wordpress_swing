package com.odde.atdd.demo.model;

import java.util.function.Consumer;

public interface Posts {
    void letEachPost(Consumer<Post> onEachPost);
}
