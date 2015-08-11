package com.odde.atdd.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    public LoginPage() {
        super("WordPress-Swing");
        setSize(new Dimension(640, 480));

        JPanel panel = new JPanel();
        setContentPane(panel);

        JButton login = new JButton("login");
        panel.add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardPage();
            }
        });

        addTextFieldWithLabel(panel, "user_name", "Please input user name");

        addPasswordFieldWithLabel(panel, "password", "Please input password");

        addTextFieldWithLabel(panel, "host_site", "Please input host site");
    }

    private void addPasswordFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        newLabel(panel, labelName).setLabelFor(newPassword(panel, defaultText));
    }

    private void addTextFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        newLabel(panel, labelName).setLabelFor(newText(panel, defaultText));
    }

    private JPasswordField newPassword(JPanel panel, String defaultText) {
        JPasswordField password = new JPasswordField(defaultText);
        panel.add(password);
        return password;
    }

    private JLabel newLabel(JPanel panel, String labelName) {
        JLabel label = new JLabel(labelName);
        panel.add(label);
        return label;
    }

    private JTextField newText(JPanel panel, String defaultText) {
        JTextField text = new JTextField(defaultText);
        panel.add(text);
        return text;
    }
}
