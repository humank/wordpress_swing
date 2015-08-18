package com.odde.atdd.demo.controller;

import com.odde.atdd.demo.model.Credential;
import com.odde.atdd.demo.model.PostsFactory;
import com.odde.atdd.demo.view.DashboardPage;
import com.odde.atdd.demo.view.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActionListener implements ActionListener {

    private final LoginPage loginPage;

    public LoginActionListener(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Credential credential = this.loginPage.getAuthentication();

        if (credential.getUserName().isEmpty()) {
            this.loginPage.showError("please input user name");
            return;
        }

        if (credential.getPassword().isEmpty()) {
            this.loginPage.showError("please input password");
            return;
        }

        credential.authenticate(() -> {
            new DashboardPage(PostsFactory.create());
        }, () -> {
            this.loginPage.showError("incorrect user name or password");
        });
    }
}
