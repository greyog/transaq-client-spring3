package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class DisconnectCommand extends AbstractCommand{
//    @XmlAttribute
//    String id = "disconnect";

    public DisconnectCommand() {
        super("disconnect");
    }
}
