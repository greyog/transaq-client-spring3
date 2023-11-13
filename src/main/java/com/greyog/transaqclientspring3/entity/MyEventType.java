package com.greyog.transaqclientspring3.entity;


import lombok.Getter;

@Getter
public enum MyEventType {

    SERVER_CLIENT_OK("ok"),
    CONNECTED("connected"),
    POSITIONS("positions");

    private final String message;

    MyEventType(String message) {
        this.message = message;
    }
}
