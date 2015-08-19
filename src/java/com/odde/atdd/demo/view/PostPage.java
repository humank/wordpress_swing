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
        setLocationRelativeTo(owner);

        ContentPanel contentPanel = new ContentPanel(this);

        contentPanel.newLabel("blog content");
        contentPanel.newLabel("----------------------------------");
        contentPanel.newLabel("Comments from others: ");

        post.processAllComments(comment -> contentPanel.newLabel(comment.content));

        contentPanel.newLabel("----------------------------------");
        comment = contentPanel.newTextFieldWithLabel("Your comment: ", "Please add your comment");

        contentPanel.newButton("post").addActionListener(new CommentActionListener(this, post));

        pack();
        setVisible(true);
    }

    public String getComment() {
        return comment.getText();
    }
}
