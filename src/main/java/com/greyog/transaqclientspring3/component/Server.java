package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.MyEventType;
import com.greyog.transaqclientspring3.entity.message.Client;
import com.greyog.transaqclientspring3.entity.message.Positions;
import com.greyog.transaqclientspring3.entity.message.ServerStatus;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Server {

    private ServerStatus serverStatus;
    @Getter
    private Positions positions = new Positions();

    @Autowired
    private CustomSpringEventPublisher eventPublisher;

    private final List<Client> clients = new ArrayList<>();
    private String fortsId;

    public void setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
        if (serverStatus.connected && fortsId != null) {
            eventPublisher.publishServerStatusEvent(MyEventType.SERVER_CLIENT_OK);
        }
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

    public void setPositions(Positions positions) {
        this.positions = positions;
        eventPublisher.publishServerStatusEvent(MyEventType.POSITIONS);
    }
}
