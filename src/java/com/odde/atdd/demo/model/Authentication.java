package com.odde.atdd.demo.model;

public interface Authentication {

    void authenticate(final Runnable onSuccess, final Runnable onFailed);
    String getUserName();
    String getPassword();
}
