package com.odde.atdd.demo;

import java.util.List;
import java.util.Map;

public abstract class FetchBlogListAbstract {
    protected String mUsername;
    protected String mPassword;

    public interface Callback {
        void onSuccess(List<Map<String, Object>> userBlogList);
        void onError(int errorMessageId, boolean httpAuthRequired, boolean erroneousSslCertificate);
    }

    public FetchBlogListAbstract(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    public void execute(final Callback callback) {
        fetchBlogList(callback);
    }

    protected abstract void fetchBlogList(final Callback callback);
}