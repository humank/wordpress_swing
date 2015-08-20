package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class PostsFactory {
    public static Posts createPosts() {
        return new WordPressPosts(new WordPressAdaptor());
    }

    public static Post createPost(String title, Integer id, String content, boolean isAllowedToComment) {
        if (isAllowedToComment)
            return new WordPressPostWithCommentOpen(title, id, new WordPressAdaptor(), content);
        else
            return new WordPressPostWithCommentClosed(title, id, new WordPressAdaptor(), content);
    }
}
