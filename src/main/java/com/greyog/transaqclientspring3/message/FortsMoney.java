package com.greyog.transaqclientspring3.message;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forts_money")
public class FortsMoney {
    public String client;
    public String union;
    public Markets markets;
    public String shortname;
    public double blocked;
    public double varmargin;
    public double current;
    public double free;
}
