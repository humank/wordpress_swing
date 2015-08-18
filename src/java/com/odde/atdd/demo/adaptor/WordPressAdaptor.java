package com.odde.atdd.demo.adaptor;

import net.bican.wordpress.Post;
import net.bican.wordpress.Wordpress;
import net.bican.wordpress.exceptions.InsufficientRightsException;
import redstone.xmlrpc.XmlRpcFault;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> getAllPosts() {

        List<String> result = new ArrayList<>();

        try {
            Wordpress wp = new Wordpress("odd-e", "s3cr3t", "http://172.28.128.3/xmlrpc.php");

            List<Post> posts = wp.getPosts();

            for (Post post : posts) {
                result.add(post.getPost_title());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlRpcFault xmlRpcFault) {
            xmlRpcFault.printStackTrace();
        }

        return result;
    }
}
