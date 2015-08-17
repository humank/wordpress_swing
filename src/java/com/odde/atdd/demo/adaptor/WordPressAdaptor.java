package com.odde.atdd.demo.adaptor;

import net.bican.wordpress.Wordpress;
import net.bican.wordpress.exceptions.InsufficientRightsException;
import redstone.xmlrpc.XmlRpcFault;

import java.net.MalformedURLException;

public class WordPressAdaptor {

    public void authenticate(String userName, String password, String hostSite, final Runnable onSuccess, final Runnable onFailed) {
        try {
            new Wordpress(userName, password, hostSite + "/xmlrpc.php").getProfile();
            onSuccess.run();
        } catch (XmlRpcFault xmlRpcFault) {
            onFailed.run();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InsufficientRightsException e) {
            e.printStackTrace();
        }
    }

}
