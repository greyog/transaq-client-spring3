package com.greyog.transaqclientspring3.entity;

public enum MyEvent {
    SERVER_CLIENT_OK("ok"),
    CONNECTED("connected");

    private String message;

    MyEvent(String message) {
        this.message = message;
    }
}
