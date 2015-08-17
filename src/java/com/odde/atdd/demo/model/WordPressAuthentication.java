package com.odde.atdd.demo.model;

import net.bican.wordpress.Wordpress;
import redstone.xmlrpc.XmlRpcFault;

import java.net.MalformedURLException;
import java.util.function.Consumer;

public class WordPressAuthentication implements Authentication {

    private final String userName;
    private final String password;
    private final String hostSite;

    public WordPressAuthentication(String userName, String password, String hostSite) {
        this.userName = userName;
        this.password = password;
        this.hostSite = hostSite + "/xmlrpc.php";
    }

    public void authenticate(final Runnable onSuccess, final Consumer<String> onError) {
        Wordpress wp = null;
        try {
            wp = new Wordpress(userName, password, hostSite + "/xmlrpc.php");
            wp.getUsersBlogs();
            onSuccess.run();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlRpcFault xmlRpcFault) {
            onError.accept("incorrect user name or password");
        }

    }
}
