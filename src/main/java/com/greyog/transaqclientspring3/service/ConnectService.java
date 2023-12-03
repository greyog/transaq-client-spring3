package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.entity.command.AbstractCommand;
import lombok.SneakyThrows;

public interface ConnectService {
    @SneakyThrows
    <T extends AbstractCommand> String getXMLCommand(T command);

    String getRequestResult(String xmlCommand);

    <T extends AbstractCommand> String sendCommand(T command);
}
