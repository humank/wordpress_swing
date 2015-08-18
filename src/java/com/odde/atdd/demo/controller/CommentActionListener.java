package com.odde.atdd.demo.controller;

import com.odde.atdd.demo.model.Post;
import com.odde.atdd.demo.model.PostsFactory;
import com.odde.atdd.demo.view.PostPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentActionListener implements ActionListener {
    private final Post post;
    private final PostPage postPage;

    public CommentActionListener(PostPage postPage, Post post) {
        this.postPage = postPage;
        this.post = post;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PostsFactory.create().comment(post, postPage.getComment());
    }
}
