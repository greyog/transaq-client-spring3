package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@XmlRootElement(name = "forts_position")
@Getter
public class FortsPosition  implements Loggable {
    public String client;
    public int secid;
    public String union;
    public String seccode;
    public Markets markets;
    public int startnet;
    public int openbuys;
    public int opensells;
    public int totalnet;
    public int todaybuy;
    public int todaysell;
    public double optmargin;
    public double varmargin;
    public int expirationpos;

}
