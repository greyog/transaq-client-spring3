package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@XmlRootElement(name = "server_status")
@ToString
public class ServerStatus implements Loggable{
    @XmlAttribute
    public int sys_ver;
    @XmlAttribute
    public int build;
    @XmlAttribute
    public String server_tz;
    @XmlAttribute
    public int id;
    @XmlAttribute
    public boolean connected;

    public ServerStatus() {

    }

    public ServerStatus(boolean isConnected) {
        connected = isConnected;
    }

    @Override
    public void log() {
        log.info(this.toString());
    }
}
