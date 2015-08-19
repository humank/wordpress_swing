package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.LoginActionListener;
import com.odde.atdd.demo.model.Credential;
import com.odde.atdd.demo.model.CredentialFactory;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JDialog {

    private static final String DEFAULT_HOST_SITE = "http://odd-pi.local";
    private final JPasswordField password;
    private final JTextField userName;
    private final JTextField hostSite;

    public LoginPage(Window owner) {
        super(owner);
        setTitle("Sign in");
        setLocationRelativeTo(null);

        ContentPanel contentPanel = new ContentPanel(this);

        contentPanel.newButton("login").addActionListener(new LoginActionListener(this));

        userName = contentPanel.newTextFieldWithLabel("User Name: ", "Please input user name");

        password = contentPanel.newPasswordFieldWithLabel("Password: ", "Please input password");

        hostSite = contentPanel.newTextFieldWithLabel("WordPress Site: ", DEFAULT_HOST_SITE);

        pack();
        setVisible(true);
    }

    public void showError(String errorMsg) {
        JDialog dialog = new JDialog(this, "Error");
        ContentPanel contentPanel = new ContentPanel(dialog);
        contentPanel.newLabel(errorMsg);
        dialog.setLocationRelativeTo(this);
        dialog.pack();
        dialog.setVisible(true);
    }

    public Credential getCredential() {
        return CredentialFactory.create(userName.getText(), String.valueOf(password.getPassword()), hostSite.getText());
    }
}
