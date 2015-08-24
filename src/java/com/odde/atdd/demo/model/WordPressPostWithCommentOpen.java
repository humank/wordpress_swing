package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class WordPressPostWithCommentOpen extends WordPressPost {
    public WordPressPostWithCommentOpen(String title, Integer id, WordPressAdaptor wordPressAdaptor, String content) {
        super(title, id, wordPressAdaptor, content);
    }

    @Override
    public void allowToCommentOrNot(Runnable yes, Runnable no) {
        yes.run();
    }
}
