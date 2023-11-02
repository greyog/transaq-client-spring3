package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.ToString;

@XmlRootElement
@ToString
public class Error implements Loggable{
    public String text;
}
