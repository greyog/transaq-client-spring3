package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.event.ServerStatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishServerStatusEvent(final String message) {
        ServerStatusEvent serverStatusEvent = new ServerStatusEvent(this, message);
        applicationEventPublisher.publishEvent(serverStatusEvent);
    }
}