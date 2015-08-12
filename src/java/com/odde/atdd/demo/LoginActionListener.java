package com.odde.atdd.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class LoginActionListener implements ActionListener {

    private final JFrame loginPage;

    public LoginActionListener(JFrame loginPage) {
        this.loginPage = loginPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        FetchBlogListWPOrg fetchBlogListWPOrg = new FetchBlogListWPOrg("odd-e", "s3cr3t", "http://172.28.128.3/xmlrpc.php");
        fetchBlogListWPOrg.execute(new FetchBlogListAbstract.Callback() {
            @Override
            public void onSuccess(final List<Map<String, Object>> userBlogList) {
                new DashboardPage();
            }

            @Override
            public void onError(final int messageId, final boolean httpAuthRequired,
                                final boolean erroneousSslCertificate) {
                new JDialog(LoginActionListener.this.loginPage, "incorrect user name or password");
            };
        });

    }
}
