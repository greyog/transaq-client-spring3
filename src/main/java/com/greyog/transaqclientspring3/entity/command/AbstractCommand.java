package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.ToString;

@ToString
public abstract class AbstractCommand {
    @XmlAttribute
    final String id;

    public AbstractCommand(String id) {
        this.id = id;
    }
}
