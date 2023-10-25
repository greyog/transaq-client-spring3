package com.greyog.transaqclientspring3.command;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "command")
public class GetFortsPositionCommand {
    @XmlAttribute
    String id = "get_forts_positions";
}
