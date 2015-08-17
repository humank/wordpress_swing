package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class AuthenticationFactory {

    public static Authentication create(String userName, String password, String hostSite) {
        return new WordPressAuthentication(userName, password, hostSite, new WordPressAdaptor());
    }
}
