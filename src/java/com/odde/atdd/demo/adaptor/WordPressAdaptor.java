package com.odde.atdd.demo.adaptor;

import com.odde.atdd.demo.model.Credential;
import com.odde.atdd.demo.model.PostsFactory;
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

    private void try_and_output_any_unexpected_exceptions(final RunnableWithXmlRpcExceptions runnable) {
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
        try_and_output_any_unexpected_exceptions(() ->
                wordPressWithCredential(credential).getPosts().stream().
                        forEach(post -> {
                            onEachPost.accept(PostsFactory.createPost(post.getPost_title(), post.getPost_id(), post.getPost_content(),
                                    !post.getComment_status().equals("closed")));
                        }));
    }

    public void comment(Credential credential, com.odde.atdd.demo.model.Post post, String comment) {
        try_and_output_any_unexpected_exceptions(() ->
                wordPressWithCredential(credential).newComment(post.getId(), 0, comment, null, null, null));
    }

    public void getAllComments(Credential credential, com.odde.atdd.demo.model.Post post, Consumer<com.odde.atdd.demo.model.Comment> onEachComment) {
        try_and_output_any_unexpected_exceptions(() ->
                wordPressWithCredential(credential).getComments("all", post.getId(), 0, 0).stream().
                        forEach(comment ->
                                onEachComment.accept(new com.odde.atdd.demo.model.Comment(comment.getContent()))));
    }
}
