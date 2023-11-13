package com.greyog.transaqclientspring3.entity.event;

import com.greyog.transaqclientspring3.entity.MyEventType;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ServerStatusEvent extends ApplicationEvent {

    private final MyEventType eventType;

    public ServerStatusEvent(Object source, MyEventType eventType) {
        super(source);
        this.eventType = eventType;
    }

}