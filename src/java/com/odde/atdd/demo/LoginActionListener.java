package com.odde.atdd.demo;

import net.bican.wordpress.Wordpress;
import redstone.xmlrpc.XmlRpcFault;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActionListener implements ActionListener {

    private final LoginPage loginPage;

    public LoginActionListener(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Wordpress wp = new Wordpress("odd-e", this.loginPage.getPassword(), "http://172.28.128.3/xmlrpc.php");

            wp.getUsersBlogs();

            new DashboardPage();
        } catch (XmlRpcFault xmlRpcFault) {
            this.loginPage.showError("incorrect user name or password");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
