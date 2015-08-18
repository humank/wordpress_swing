package com.odde.atdd.demo.view;

import com.odde.atdd.demo.model.Post;

import javax.swing.*;
import java.awt.*;

public class PostPage extends JFrame{
    public PostPage(Post post) {
        super(post.title);
        setSize(new Dimension(640, 480));

        new ContentPanel(this)
            .newTextFieldWithLabel("comment", "Please add your comment");

        setVisible(true);
    }
}
