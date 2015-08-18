package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class WordPressCredential implements Credential {

    private final String userName;
    private final String password;
    private final String hostSite;
    private final WordPressAdaptor wordPressAdaptor;

    public WordPressCredential(String userName, String password, String hostSite, WordPressAdaptor adaptor) {
        this.userName = userName;
        this.password = password;
        this.hostSite = hostSite;
        this.wordPressAdaptor = adaptor;
    }

    public void authenticate(final Runnable onSuccess, final Runnable onFailed) {
        this.wordPressAdaptor.authenticate(this, onSuccess, onFailed);
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getHostSite() {
        return hostSite;
    }
}
