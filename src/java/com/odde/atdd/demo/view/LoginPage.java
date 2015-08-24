package com.odde.atdd.demo.view;

import com.odde.atdd.demo.controller.LoginActionListener;
import com.odde.atdd.demo.model.Credential;
import com.odde.atdd.demo.model.CredentialFactory;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JDialog implements Screen {

    private static final String DEFAULT_HOST_SITE = "http://odd-pi.local";
    private final JPasswordField password;
    private final JTextField userName;
    private final JTextField hostSite;

    public LoginPage(Window owner) {
        super(owner);

        TwoColumnsBalancedPanel contentPanel = new TwoColumnsBalancedPanel(this);

        contentPanel.newButton("login").addActionListener(new LoginActionListener(this));

        userName = contentPanel.newTextFieldWithLabel("User Name: ", "Please input user name");

        password = contentPanel.newPasswordFieldWithLabel("Password: ", "Please input password");

        hostSite = contentPanel.newTextFieldWithLabel("WordPress Site: ", DEFAULT_HOST_SITE);

        display(this, "Sign in", owner);
    }

    public void showError(String errorMsg) {
        new ErrorDialog(this, errorMsg);
    }

    public Credential getCredential() {
        return CredentialFactory.create(userName.getText(), String.valueOf(password.getPassword()), hostSite.getText());
    }
}
