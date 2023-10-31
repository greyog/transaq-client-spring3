package com.greyog.transaqclientspring3.entity.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class ServerStatusEvent extends ApplicationEvent {

    @Getter
    private String message;

    public ServerStatusEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}