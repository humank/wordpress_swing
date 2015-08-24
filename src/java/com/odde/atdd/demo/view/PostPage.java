package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.CommentActionListener;
import com.odde.atdd.demo.model.Post;

import javax.swing.*;
import java.awt.*;

public class PostPage extends JDialog implements Screen {

    private JTextField comment;

    public PostPage(Window owner, Post post) {
        super(owner);

        TwoColumnsBalancedPanel contentPanel = new TwoColumnsBalancedPanel(this);

        contentPanel.newMainContent("<html>" + post.getContent() + "</html>");
        contentPanel.newLabel("----------------------------------");
        contentPanel.newLabel("Comments from others: ");

        post.letEachComment(comment -> contentPanel.newLabel(comment.content));

        contentPanel.newLabel("----------------------------------");

        post.allowToCommentOrNot(
                () -> addSubmittableComment(post, contentPanel),
                () -> disableCommentFunctionality(contentPanel));

        display(this, post.getTitle(), owner);
    }

    private void disableCommentFunctionality(TwoColumnsBalancedPanel contentPanel) {
        comment = contentPanel.newTextFieldWithLabel("Comments are closed.", "");
        comment.setVisible(false);
    }

    private void addSubmittableComment(Post post, TwoColumnsBalancedPanel contentPanel) {
        comment = contentPanel.newTextFieldWithLabel("Your comment: ", "Please add your comment");
        addSubmitButton(post, contentPanel);
    }

    private void addSubmitButton(Post post, TwoColumnsBalancedPanel contentPanel) {
        contentPanel.newButton("post").addActionListener(new CommentActionListener(this, post));
    }

    public String getComment() {
        return comment.getText();
    }
}
