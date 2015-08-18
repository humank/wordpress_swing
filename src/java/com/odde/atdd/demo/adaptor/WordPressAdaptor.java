package com.odde.atdd.demo.adaptor;

import com.odde.atdd.demo.model.Credential;
import net.bican.wordpress.Post;
import net.bican.wordpress.Wordpress;
import net.bican.wordpress.exceptions.InsufficientRightsException;
import redstone.xmlrpc.XmlRpcFault;

import java.net.MalformedURLException;
import java.util.function.Consumer;

public class WordPressAdaptor {

    public void authenticate(Credential credential, final Runnable onSuccess, final Runnable onFailed) {
        try {
            wordPressWithCredential(credential).getProfile();
            onSuccess.run();
        } catch (XmlRpcFault xmlRpcFault) {
            onFailed.run();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InsufficientRightsException e) {
            e.printStackTrace();
        }
    }

    private Wordpress wordPressWithCredential(Credential credential) throws MalformedURLException {
        return new Wordpress(credential.getUserName(), credential.getPassword(), xmlrpcUrl(credential));
    }

    private String xmlrpcUrl(Credential credential) {
        return credential.getHostSite() + "/xmlrpc.php";
    }

    public void getAllPosts(Credential credential, final Consumer<com.odde.atdd.demo.model.Post> onEachPost) {
        try {
            for (Post post : wordPressWithCredential(credential).getPosts())
                onEachPost.accept(new com.odde.atdd.demo.model.Post(post.getPost_title()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlRpcFault xmlRpcFault) {
            xmlRpcFault.printStackTrace();
        }
    }
}
