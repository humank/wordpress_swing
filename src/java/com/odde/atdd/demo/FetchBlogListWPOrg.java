package com.odde.atdd.demo;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FetchBlogListWPOrg extends FetchBlogListAbstract {
    private String mSelfHostedUrl;

    public FetchBlogListWPOrg(String username, String password, String selfHostedUrl) {
        super(username, password);
        mSelfHostedUrl = selfHostedUrl;
    }

    private void getBlogList(String xmlrpcUri, final Callback callback) {
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL(xmlrpcUri));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            Object[] params = new Object[]{mUsername, mPassword};
            Object[] userBlogs = (Object[]) client.execute("wp.getUsersBlogs", params);
            List<Map<String, Object>> userBlogList = new ArrayList<Map<String, Object>>();
            for (Object blog : userBlogs) {
                userBlogList.add((Map<String, Object>) blog);
            }
            callback.onSuccess(userBlogList);
        } catch (XmlRpcException e) {
            e.printStackTrace();
            callback.onError(1, false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fetchBlogList(Callback callback) {
        getBlogList(mSelfHostedUrl, callback);
    }

}
