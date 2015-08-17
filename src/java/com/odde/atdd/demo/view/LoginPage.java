package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.LoginActionListener;
import com.odde.atdd.demo.model.Authentication;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    private final JPasswordField password;
    private final JTextField userName;
    private final JTextField hostSite;

    public LoginPage() {
        super("WordPress-Swing");
        setSize(new Dimension(640, 480));

        JPanel panel = newContentPanel();

        newButton(panel, "login").addActionListener(new LoginActionListener(this));

        userName = newTextFieldWithLabel(panel, "user_name", "Please input user name");

        password = newPasswordFieldWithLabel(panel, "password", "Please input password");

        hostSite = newTextFieldWithLabel(panel, "host_site", "Please input host site");

        setVisible(true);
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

    private JPasswordField newPasswordFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        JPasswordField field = newPassword(panel, defaultText);
        newLabel(panel, labelName).setLabelFor(field);
        return field;
    }

    private JTextField newTextFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        JTextField textField = newText(panel, defaultText);
        newLabel(panel, labelName).setLabelFor(textField);
        return textField;
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

    public void showError(String errorMsg) {
        new JDialog(this, errorMsg).setVisible(true);
    }

    public Authentication getAuthentication() {
        return new Authentication(userName.getText(), String.valueOf(password.getPassword()), hostSite.getText() + "/xmlrpc.php");
    }
}
