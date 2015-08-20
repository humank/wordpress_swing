package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class WordPressPostWithCommentClosed extends WordPressPost {

    public WordPressPostWithCommentClosed(String title, Integer id, WordPressAdaptor wordPressAdaptor, String content) {
        super(title, id, wordPressAdaptor, content);
    }

    @Override
    public void allowToComment(Runnable yes, Runnable no) {
        no.run();
    }
}
