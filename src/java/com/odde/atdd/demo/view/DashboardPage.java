package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.PostActionListener;
import com.odde.atdd.demo.model.Post;
import com.odde.atdd.demo.model.Posts;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JDialog {

    public DashboardPage(Window owner, Posts posts) {
        super(owner);
        setTitle("Dashboard");
        setSize(new Dimension(640, 480));

        ContentPanel contentPanel = new ContentPanel(this);
        contentPanel.newLabel("Dashboard");

        posts.processAllPosts((Post post) -> {
            contentPanel.newButton(post.title)
                    .addActionListener(new PostActionListener(this, post));
        });

        setVisible(true);
    }

}
