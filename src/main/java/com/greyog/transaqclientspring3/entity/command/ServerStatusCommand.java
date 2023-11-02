package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServerStatusCommand extends AbstractCommand{
//    @XmlAttribute
//    String id = "server_status";

    public ServerStatusCommand() {
        super("server_status");
    }
}
