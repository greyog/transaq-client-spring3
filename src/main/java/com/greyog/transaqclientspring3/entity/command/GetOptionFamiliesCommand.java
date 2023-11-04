package com.greyog.transaqclientspring3.entity.command;

import com.greyog.transaqclientspring3.entity.message.Security;
import jakarta.xml.bind.annotation.*;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOptionFamiliesCommand extends AbstractCommand{

    public GetOptionFamiliesCommand() {
        super("get_option_families");
    }

    public GetOptionFamiliesCommand(Security security) {
        super("get_option_families");
        this.security = security;
    }

    @XmlElement
    private Security security;

}
