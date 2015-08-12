package com.odde.atdd.demo;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage() {
        super("WordPress-Swing");
        setSize(new Dimension(640, 480));

        JPanel panel = newContentPanel();

        newButton(panel, "login").addActionListener(new LoginActionListener(this));

        newTextFieldWithLabel(panel, "user_name", "Please input user name");

        newPasswordFieldWithLabel(panel, "password", "Please input password");

        newTextFieldWithLabel(panel, "host_site", "Please input host site");
    }

    private JPanel newContentPanel() {
        JPanel panel = new JPanel();
        setContentPane(panel);
        return panel;
    }

    private JButton newButton(JPanel panel, String name) {
        JButton login = new JButton(name);
        panel.add(login);
        return login;
    }

    private void newPasswordFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        newLabel(panel, labelName).setLabelFor(newPassword(panel, defaultText));
    }

    private void newTextFieldWithLabel(JPanel panel, String labelName, String defaultText) {
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
