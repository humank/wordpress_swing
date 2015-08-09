package com.odde.atdd.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("WordPress-Swing");
        frame.setSize(new Dimension(640, 480));

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

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

        frame.setVisible(true);
    }

    private static void addPasswordFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        newLabel(panel, labelName).setLabelFor(newPassword(panel, defaultText));
    }

    private static void addTextFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        newLabel(panel, labelName).setLabelFor(newText(panel, defaultText));
    }

    private static JPasswordField newPassword(JPanel panel, String defaultText) {
        JPasswordField password = new JPasswordField(defaultText);
        panel.add(password);
        return password;
    }

    private static JLabel newLabel(JPanel panel, String labelName) {
        JLabel label = new JLabel(labelName);
        panel.add(label);
        return label;
    }

    private static JTextField newText(JPanel panel, String defaultText) {
        JTextField text = new JTextField(defaultText);
        panel.add(text);
        return text;
    }

}
