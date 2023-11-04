package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.command.ChangePasswordCommand;
import com.greyog.transaqclientspring3.entity.command.GetFortsPositionsCommand;
import com.greyog.transaqclientspring3.entity.command.GetMarketsCommand;
import com.greyog.transaqclientspring3.entity.event.ServerStatusEvent;
import com.greyog.transaqclientspring3.service.ConnectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServerStatusEventListener {

    @Autowired
    private ConnectService connectService;
    @Autowired
    private Environment environment;
    @Autowired
    private Server server;

    @EventListener
    public void onApplicationEvent(ServerStatusEvent event) {
        log.info("Received spring custom event - " + event.getMessage());
        switch (event.getMessage()) {
            case "ok" -> {
                var getFortsPositionCommand = new GetFortsPositionsCommand();
                getFortsPositionCommand.client = server.getFortsClient();
                connectService.sendCommand(getFortsPositionCommand);

                connectService.sendCommand(new GetMarketsCommand());
            }
            case "connected" -> {
                var changePasswordCommand = new ChangePasswordCommand(
                        environment.getProperty("TRANSAQ_PASSWORD"),
                        environment.getProperty("TRANSAQ_NEW_PASSWORD")
                );
                connectService.sendCommand(changePasswordCommand);
            }
        }
    }
}
