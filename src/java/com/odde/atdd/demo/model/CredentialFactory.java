package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class CredentialFactory {

    private static final String ADMIN_USER_NAME = "odd-e";
    private static final String ADMIN_PASSWORD = "s3cr3t";
    private static Credential current;

    public static Credential create(String userName, String password, String hostSite) {
        current = new WordPressCredential(userName, password, hostSite, new WordPressAdaptor());
        return current;
    }

    public static Credential createAdmin() {
        return new WordPressCredential(ADMIN_USER_NAME, ADMIN_PASSWORD, current.getHostSite(), new WordPressAdaptor());
    }

    public static Credential current() {
        return current;
    }
}
