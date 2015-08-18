package com.odde.atdd.demo.model;

public interface Credential {

    void authenticate(final Runnable onSuccess, final Runnable onFailed);
    String getUserName();
    String getPassword();
    String getHostSite();
}
