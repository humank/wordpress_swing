package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.PostActionListener;
import com.odde.atdd.demo.model.Posts;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JDialog implements Screen {

    public DashboardPage(Window owner, Posts posts) {
        super(owner);

        ContentPanel contentPanel = new ContentPanel(this);

        posts.processAllPosts(post ->
                contentPanel.newButton(post.getTitle())
                    .addActionListener(new PostActionListener(this, post)));

        display(this, "Dashboard", owner);
    }

}
