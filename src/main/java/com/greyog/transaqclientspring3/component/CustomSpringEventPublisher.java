package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.MyEventType;
import com.greyog.transaqclientspring3.entity.event.ServerStatusEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishServerStatusEvent(final MyEventType event) {
        ServerStatusEvent serverStatusEvent = new ServerStatusEvent(this, event);
        applicationEventPublisher.publishEvent(serverStatusEvent);
    }
}