package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "command")
public class ServerStatusCommand {
    @XmlAttribute
    String id = "server_status";
}
