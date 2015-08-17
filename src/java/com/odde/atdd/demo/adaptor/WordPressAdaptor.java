package com.odde.atdd.demo.adaptor;

import net.bican.wordpress.Wordpress;
import redstone.xmlrpc.XmlRpcFault;

import java.net.MalformedURLException;

public class WordPressAdaptor {

    public void authenticate(String userName, String password, String hostSite, final Runnable onSuccess, final Runnable onFailed) {
        Wordpress wp = null;
        try {
            wp = new Wordpress(userName, password, hostSite + "/xmlrpc.php");
            wp.getUsersBlogs();
            onSuccess.run();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlRpcFault xmlRpcFault) {
            onFailed.run();
        }
    }

}
