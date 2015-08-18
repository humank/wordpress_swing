package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class CredentialFactory {

    private static Credential current;

    public static Credential create(String userName, String password, String hostSite) {
        current = new WordPressCredential(userName, password, hostSite, new WordPressAdaptor());
        return current;
    }

    public static Credential createAdmin() {
        return new WordPressCredential("odd-e", "s3cr3t", current.getHostSite(), new WordPressAdaptor());
    }
}
