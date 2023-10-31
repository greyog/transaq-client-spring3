package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.command.GetFortsPositionCommand;
import com.greyog.transaqclientspring3.entity.event.ServerStatusEvent;
import com.greyog.transaqclientspring3.service.ConnectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServerStatusEventListener implements ApplicationListener<ServerStatusEvent> {

    @Autowired
    private ConnectService connectService;

    @Override
    public void onApplicationEvent(ServerStatusEvent event) {
        log.info("Received spring custom event - " + event.getMessage());
        if (event.getMessage().equals("ok")) {
            connectService.getRequestResult(connectService.getXMLCommand(new GetFortsPositionCommand()));
        }
    }
}
