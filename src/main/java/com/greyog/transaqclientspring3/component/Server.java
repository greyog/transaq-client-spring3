package com.greyog.transaqclientspring3.component;

import com.greyog.transaqclientspring3.entity.command.GetFortsPositionCommand;
import com.greyog.transaqclientspring3.entity.message.ServerStatus;
import com.greyog.transaqclientspring3.service.ConnectService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Server {

    @Setter
    private ServerStatus serverStatus;

//    public void setServerStatus(ServerStatus serverStatus) {
//        this.serverStatus = serverStatus;
//        if (serverStatus.connected) {
//            var result = connectService.sendCommand(new GetFortsPositionCommand());
//        }
//    }

//    @Autowired
//    private ConnectService connectService;
}
