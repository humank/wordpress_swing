package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.LoginActionListener;
import com.odde.atdd.demo.model.Credential;
import com.odde.atdd.demo.model.CredentialFactory;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JDialog {

    private final JPasswordField password;
    private final JTextField userName;
    private final JTextField hostSite;

    public LoginPage(Window owner) {
        super(owner);
        setTitle("Sign in");
        setSize(new Dimension(640, 480));

        ContentPanel contentPanel = new ContentPanel(this);

        contentPanel.newButton("login").addActionListener(new LoginActionListener(this));

        userName = contentPanel.newTextFieldWithLabel("user_name", "Please input user name");

        password = contentPanel.newPasswordFieldWithLabel("password", "Please input password");

        hostSite = contentPanel.newTextFieldWithLabel("host_site", "Please input host site");

        setVisible(true);
    }

    public void showError(String errorMsg) {
        new JDialog(this, errorMsg).setVisible(true);
    }

    public Credential getCredential() {
        return CredentialFactory.create(userName.getText(), String.valueOf(password.getPassword()), hostSite.getText());
    }
}
