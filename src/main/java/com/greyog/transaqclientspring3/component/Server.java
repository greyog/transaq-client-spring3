package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.message.Client;
import com.greyog.transaqclientspring3.entity.message.ServerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Server {

    private ServerStatus serverStatus;

    @Autowired
    private CustomSpringEventPublisher eventPublisher;

    private final List<Client> clients = new ArrayList<>();
    private String fortsId;

    public void setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
        eventPublisher.publishServerStatusEvent(serverStatus.connected && fortsId != null? "ok" : "no");
//        eventPublisher.publishServerStatusEvent(serverStatus.connected ? "connected" : "no");
    }

    public void addClientInfo(Client client) {
        clients.add(client);
        if (client.forts_acc != null) {
            fortsId = client.forts_acc;
        }
    }

    public String getFortsClient() {
        return fortsId;
    }

    public boolean isConnected() {
        return serverStatus != null && serverStatus.connected;
    }

//    public void setServerStatus(ServerStatus serverStatus) {
//        this.serverStatus = serverStatus;
//        if (serverStatus.connected) {
//            var result = connectService.sendCommand(new GetFortsPositionCommand());
//        }
//    }

//    @Autowired
//    private ConnectService connectService;
}
