package com.odde.atdd.demo.adaptor;

import com.odde.atdd.demo.model.Credential;
import net.bican.wordpress.Comment;
import net.bican.wordpress.Post;
import net.bican.wordpress.Wordpress;
import net.bican.wordpress.exceptions.InsufficientRightsException;
import net.bican.wordpress.exceptions.ObjectNotFoundException;
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

    private void try_and_output_any_unexpected_exceptions(final RunnableWithXmlRpcExpections runnable) {
        try {
            runnable.run();
        } catch (InsufficientRightsException e) {
            e.printStackTrace();
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        } catch (XmlRpcFault xmlRpcFault) {
            xmlRpcFault.printStackTrace();
        } catch (MalformedURLException e) {
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
        try_and_output_any_unexpected_exceptions(() -> {
            for (Post post : wordPressWithCredential(credential).getPosts())
                onEachPost.accept(new com.odde.atdd.demo.model.Post(post.getPost_title(), post.getPost_id()));
        });
    }

    public void comment(Credential credential, com.odde.atdd.demo.model.Post post, String comment) {
        try_and_output_any_unexpected_exceptions(() -> {
            wordPressWithCredential(credential).newComment(post.id, 0, comment, null, null, null);
        });
    }

    public void getAllComments(Credential credential, com.odde.atdd.demo.model.Post post, Consumer<com.odde.atdd.demo.model.Comment> onEachComment) {
        try_and_output_any_unexpected_exceptions(() -> {
            for (Comment comment : wordPressWithCredential(credential).getComments("all", post.id, 0, 0))
                onEachComment.accept(new com.odde.atdd.demo.model.Comment(comment.getContent()));
        });
    }
}
