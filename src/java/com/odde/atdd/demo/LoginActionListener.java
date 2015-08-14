package com.odde.atdd.demo;

import net.bican.wordpress.Wordpress;
import redstone.xmlrpc.XmlRpcFault;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class LoginActionListener implements ActionListener {

    private final JFrame loginPage;

    public LoginActionListener(JFrame loginPage) {
        this.loginPage = loginPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Wordpress wp = new Wordpress("odd-e", "s3cr3t", "http://172.28.128.3/xmlrpc.php");

            wp.getUsersBlogs();

            new DashboardPage();
        } catch (MalformedURLException e1) {
        } catch (XmlRpcFault xmlRpcFault) {
            new JDialog(LoginActionListener.this.loginPage, "incorrect user name or password").setVisible(true);
        }

    }
}
