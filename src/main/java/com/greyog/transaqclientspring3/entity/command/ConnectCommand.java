package com.greyog.transaqclientspring3.entity.command;

import jakarta.xml.bind.annotation.*;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

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

    @Builder
    public ConnectCommand(String login, String password, String host, Integer port, Integer rqdelay, Integer session_timeout, Integer request_timeout, String text, Integer push_u_limits, Boolean autopos) {
        this();
        this.login = login;
        this.password = password;
        this.host = host;
        this.port = port;
        this.rqdelay = rqdelay;
        this.session_timeout = session_timeout;
        this.request_timeout = request_timeout;
        this.text = text;
        this.push_u_limits = push_u_limits;
        this.autopos = autopos;
    }

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