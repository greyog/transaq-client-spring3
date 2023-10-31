package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@XmlRootElement(name = "forts_money")
public class FortsMoney implements Loggable {
    public String client;
    public String union;
    public Markets markets;
    public String shortname;
    public double blocked;
    public double varmargin;
    public double current;
    public double free;

    @Override
    public void log() {
        log.info(this.toString());
    }
}
