package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class WordPressAuthentication implements Authentication {

    private final String userName;
    private final String password;
    private final WordPressAdaptor wpAdaptor;

    public WordPressAuthentication(String userName, String password, WordPressAdaptor adaptor) {
        this.userName = userName;
        this.password = password;
        this.wpAdaptor = adaptor;
    }

    public void authenticate(final Runnable onSuccess, final Consumer<String> onError) {
        this.wpAdaptor.authenticate(userName, password,
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
