package com.odde.atdd.demo.controller;

import com.odde.atdd.demo.model.Post;
import com.odde.atdd.demo.view.PostPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostActionListener implements ActionListener {
    private final Post post;

    public PostActionListener(Post post) {
        this.post = post;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new PostPage(post);
    }
}
