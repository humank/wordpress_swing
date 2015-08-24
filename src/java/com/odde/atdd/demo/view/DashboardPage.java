package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.PostActionListener;
import com.odde.atdd.demo.model.Post;
import com.odde.atdd.demo.model.Posts;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JDialog implements Screen {

    public DashboardPage(Window owner, Posts posts) {
        super(owner);

        TwoColumnsBalancedPanel contentPanel = new TwoColumnsBalancedPanel(this);

        posts.letEachPost(post -> addOpenButton(contentPanel, post));

        display(this, "Dashboard", owner);
    }

    private void addOpenButton(TwoColumnsBalancedPanel contentPanel, Post post) {
        contentPanel.newButton(post.getTitle())
            .addActionListener(new PostActionListener(this, post));
    }

}
