package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.CommentActionListener;
import com.odde.atdd.demo.model.Post;

import javax.swing.*;
import java.awt.*;

public class PostPage extends JDialog {

    private final JTextField comment;

    public PostPage(Window owner, Post post) {
        super(owner);
        setTitle(post.getTitle());
        setSize(new Dimension(640, 480));

        ContentPanel contentPanel = new ContentPanel(this);

        comment = contentPanel.newTextFieldWithLabel("comment", "Please add your comment");

        contentPanel.newButton("post").addActionListener(new CommentActionListener(this, post));

        post.processAllComments(comment -> contentPanel.newLabel(comment.content));

        setVisible(true);
    }

    public String getComment() {
        return comment.getText();
    }
}
