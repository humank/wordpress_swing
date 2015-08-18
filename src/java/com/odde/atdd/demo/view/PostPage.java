package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.CommentActionListener;
import com.odde.atdd.demo.model.Post;

import javax.swing.*;
import java.awt.*;

public class PostPage extends JFrame{

    private final JTextField comment;

    public PostPage(Post post) {
        super(post.title);
        setSize(new Dimension(640, 480));

        ContentPanel contentPanel = new ContentPanel(this);

        comment = contentPanel.newTextFieldWithLabel("comment", "Please add your comment");

        contentPanel.newButton("post").addActionListener(new CommentActionListener(this, post));

        setVisible(true);
    }

    public String getComment() {
        return comment.getText();
    }
}
