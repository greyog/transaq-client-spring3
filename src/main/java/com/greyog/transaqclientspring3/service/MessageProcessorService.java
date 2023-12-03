package com.greyog.transaqclientspring3.service;

import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;

import java.util.function.Consumer;

public interface MessageProcessorService {

    void run();

    void addListener(Consumer<String> stringConsumer);
}
