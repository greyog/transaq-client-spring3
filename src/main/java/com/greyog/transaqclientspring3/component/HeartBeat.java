package com.greyog.transaqclientspring3.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

public interface HeartBeat {
    @Async
    @Scheduled(fixedRate = 5000)
    void heartBeat() throws InterruptedException;
}
