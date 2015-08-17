package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class WordPressAuthentication implements Authentication {

    private final String userName;
    private final String password;
    private final String hostSite;
    private final WordPressAdaptor wpAdaptor;

    public WordPressAuthentication(String userName, String password, String hostSite, WordPressAdaptor adaptor) {
        this.userName = userName;
        this.password = password;
        this.hostSite = hostSite;
        this.wpAdaptor = adaptor;
    }

    public void authenticate(final Runnable onSuccess, final Consumer<String> onError) {
        this.wpAdaptor.authenticate(userName, password, hostSite,
                onSuccess, () -> {
                onError.accept("incorrect user name or password");
        });
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
