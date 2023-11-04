package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetClientLimitsCommand extends AbstractCommand{

    @XmlAttribute
    private String client;

    public GetClientLimitsCommand() {
        super("get_client_limits");
    }
}
