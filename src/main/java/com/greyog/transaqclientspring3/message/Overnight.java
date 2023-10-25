package com.greyog.transaqclientspring3.message;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Overnight {
    @XmlAttribute
    public boolean status;
}
