package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@XmlRootElement
@ToString
public class Client implements Loggable {

    public int market;
    public String currency;
    public String type;
    public String forts_acc;
    @XmlAttribute
    public String id;
    @XmlAttribute
    public boolean remove;
    public String text;
    public String union;
}
