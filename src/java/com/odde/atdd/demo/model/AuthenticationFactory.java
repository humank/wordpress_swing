package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class AuthenticationFactory {

    public static Authentication create(String userName, String password) {
        return new WordPressAuthentication(userName, password, new WordPressAdaptor());
    }
}
