package com.odde.atdd.demo.view;

import com.odde.atdd.demo.model.Post;
import com.odde.atdd.demo.model.Posts;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JFrame {

    public DashboardPage(Posts posts) {
        super("Dashboard");
        setSize(new Dimension(640, 480));

        JPanel panel = newContentPanel();

        newLabel(panel, "Dashboard");

        posts.processAllPosts((Post post) -> {
            newButton(panel, post.getTitle());
        });

        setVisible(true);
    }

    private void newButton(JPanel panel, String name) {
        JButton button = new JButton(name);
        panel.add(button);
    }

    private JPanel newContentPanel() {
        JPanel panel = new JPanel();
        setContentPane(panel);
        return panel;
    }

    private JLabel newLabel(JPanel panel, String labelName) {
        JLabel label = new JLabel(labelName);
        panel.add(label);
        return label;
    }

}
