package com.greyog.transaqclientspring3.command;

import lombok.Builder;
import lombok.Data;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConnectCommand {
    public String login;
    public String password;
    public String host;
    public int port;
    public int rqdelay;
    public int session_timeout;
    public int request_timeout;
    @XmlAttribute
    public String id = "connect";
    public String text;
}
//    "<command id=\"connect\">" +
//            "<login>" + login + "</login>" +
//            "<password>" + passwd + "</password>" +
//            "<host>" + host + "</host>" +
//            "<port>" + port + "</port>" +
//            "<rqdelay>100</rqdelay>" +
//            "<session_timeout>1000</session_timeout> " +
//            "<request_timeout>1000</request_timeout>" +
//            "</command>"