package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.PostActionListener;
import com.odde.atdd.demo.model.Posts;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JDialog {

    public DashboardPage(Window owner, Posts posts) {
        super(owner);
        setTitle("Dashboard");

        ContentPanel contentPanel = new ContentPanel(this);

        posts.processAllPosts(post ->
                contentPanel.newButton(post.getTitle())
                    .addActionListener(new PostActionListener(this, post)));

        setLocationRelativeTo(owner);
        pack();
        setVisible(true);
    }

}
