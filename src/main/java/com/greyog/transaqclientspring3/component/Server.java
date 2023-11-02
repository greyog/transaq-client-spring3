package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.message.Client;
import com.greyog.transaqclientspring3.entity.message.ServerStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class Server {

    private ServerStatus serverStatus;

    @Autowired
    private CustomSpringEventPublisher eventPublisher;

    private final List<Client> clients = new ArrayList<>();
    private String fortsAcc;

    public void setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
        eventPublisher.publishServerStatusEvent(serverStatus.connected && fortsAcc != null? "ok" : "no");

    }

    public void addClientInfo(Client client) {
        clients.add(client);
        if (client.forts_acc != null) {
            fortsAcc = client.forts_acc;
        }
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
