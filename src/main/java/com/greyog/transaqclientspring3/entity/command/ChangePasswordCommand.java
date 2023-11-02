package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChangePasswordCommand extends AbstractCommand{
//    @XmlAttribute
//    final String id = "change_pass";
    @XmlAttribute
    public String oldpass;
    @XmlAttribute
    public String newpass;

    public ChangePasswordCommand() {
        super("change_pass");
    }
}
