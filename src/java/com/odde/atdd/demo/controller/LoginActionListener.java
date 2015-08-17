package com.odde.atdd.demo.controller;

import com.odde.atdd.demo.model.Authentication;
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
        Authentication authentication = this.loginPage.getAuthentication();

        if (authentication.getUserName().isEmpty()) {
            this.loginPage.showError("please input user name");
            return;
        }

        authentication.authenticate(() -> {
            new DashboardPage();
        }, (String errorMessage) -> {
            this.loginPage.showError(errorMessage);
        });
    }
}
