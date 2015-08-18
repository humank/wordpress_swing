package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

public class CredentialFactory {

    public static Credential create(String userName, String password, String hostSite) {
        return new WordPressCredential(userName, password, hostSite, new WordPressAdaptor());
    }
}
