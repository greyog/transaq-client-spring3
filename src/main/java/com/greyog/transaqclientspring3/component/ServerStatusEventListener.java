package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.command.GetFortsPositionsCommand;
import com.greyog.transaqclientspring3.entity.event.ServerStatusEvent;
import com.greyog.transaqclientspring3.service.ConnectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServerStatusEventListener {

    @Autowired
    private ConnectService connectService;

    @Autowired
    private Server server;

    @EventListener
    public void onApplicationEvent(ServerStatusEvent event) {
        log.info("Received spring custom event - " + event.getMessage());
        if (event.getMessage().equals("ok")) {
            var getFortsPositionCommand = new GetFortsPositionsCommand();
            getFortsPositionCommand.client = "355YL/355YL";//(server.getFortsAcc());
//            client id="355YL/355YL" forts_acc=7655xif  union=401398R2XAT
            System.out.println(connectService.getXMLCommand(getFortsPositionCommand));
            connectService.sendCommand(getFortsPositionCommand);
        }
    }
}
