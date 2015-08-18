package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class PostsFactory {
    public static Posts create() {
        return new WordPressPosts(new WordPressAdaptor());
    }
}
