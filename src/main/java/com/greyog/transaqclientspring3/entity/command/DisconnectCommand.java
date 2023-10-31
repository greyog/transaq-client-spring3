package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "command")
public class DisconnectCommand {
    @XmlAttribute
    String id = "disconnect";
}
