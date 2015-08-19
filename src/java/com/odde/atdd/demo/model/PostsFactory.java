package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class PostsFactory {
    public static Posts createPosts() {
        return new WordPressPosts(new WordPressAdaptor());
    }

    public static Post createPost(String title, Integer id, String content) {
        return new WordPressPost(title, id, new WordPressAdaptor(), content);
    }
}
