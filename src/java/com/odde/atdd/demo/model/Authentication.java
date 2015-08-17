package com.odde.atdd.demo.model;

import java.util.function.Consumer;

public interface Authentication {

    void authenticate(final Runnable onSuccess, final Consumer<String> onError);
    String getUserName();
    String getPassword();
}
