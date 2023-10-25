package com.greyog.transaqclientspring3.command;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "command")
public class ServerStatusCommand {
    @XmlAttribute
    String id = "server_status";
}
