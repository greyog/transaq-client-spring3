package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "command")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConnectCommand extends AbstractCommand{
    public String login;
    public String password;
    public String host;
    public Integer port;
    public Integer rqdelay;
    public Integer session_timeout;
    public Integer request_timeout;
//    @XmlAttribute
//    public String id = "connect";
    public String text;
    public Integer push_u_limits;
    public Boolean autopos;

    public ConnectCommand() {
        super("connect");
    }
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