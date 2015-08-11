package com.odde.atdd.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new DashboardPage();
    }
}
