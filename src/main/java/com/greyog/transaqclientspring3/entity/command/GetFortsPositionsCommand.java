package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.*;
import lombok.Builder;
import lombok.Data;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetFortsPositionsCommand extends AbstractCommand{

    @XmlAttribute
    public String client;

    public GetFortsPositionsCommand() {
        super("get_forts_positions");
    }
}
