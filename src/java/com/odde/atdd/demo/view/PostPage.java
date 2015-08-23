package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.CommentActionListener;
import com.odde.atdd.demo.model.Post;

import javax.swing.*;
import java.awt.*;

public class PostPage extends JDialog {

    private JTextField comment;

    public PostPage(Window owner, Post post) {
        super(owner);
        setTitle(post.getTitle());

        ContentPanel contentPanel = new ContentPanel(this);

        contentPanel.newMainContent("<html>" + post.getContent() + "</html>");
        contentPanel.newLabel("----------------------------------");
        contentPanel.newLabel("Comments from others: ");

        post.processAllComments(comment -> contentPanel.newLabel(comment.content));

        contentPanel.newLabel("----------------------------------");

        post.allowToComment(() -> {
            comment = contentPanel.newTextFieldWithLabel("Your comment: ", "Please add your comment");
            contentPanel.newButton("post").addActionListener(new CommentActionListener(this, post));
        }, () -> {
            comment = contentPanel.newTextFieldWithLabel("Comments are closed.", "");
            comment.setVisible(false);
        });

        setLocationRelativeTo(owner);
        pack();
        setVisible(true);
    }

    public String getComment() {
        return comment.getText();
    }
}
