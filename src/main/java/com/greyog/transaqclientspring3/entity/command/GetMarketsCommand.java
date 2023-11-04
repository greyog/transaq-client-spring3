package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetMarketsCommand extends AbstractCommand{

    public GetMarketsCommand() {
        super("get_markets");
    }
}
