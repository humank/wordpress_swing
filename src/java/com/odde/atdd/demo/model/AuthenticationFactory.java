package com.odde.atdd.demo.model;

public class AuthenticationFactory {

    public static Authentication create(String userName, String password, String hostSite) {
        return new WordPressAuthentication(userName, password, hostSite);
    }
}
