package com.odde.atdd.demo.view;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import javax.swing.*;
import java.util.List;
import java.awt.*;

public class DashboardPage extends JFrame {

    public DashboardPage() {
        super("Dashboard");
        setSize(new Dimension(640, 480));

        JPanel panel = newContentPanel();

        newLabel(panel, "Dashboard");

        WordPressAdaptor wordPressAdaptor = new WordPressAdaptor();

        List<String> allPosts = wordPressAdaptor.getAllPosts();

        for (String postName : allPosts) {
            newButton(panel, postName);
        }

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
