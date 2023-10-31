package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.ToString;

@XmlRootElement
@ToString
public class SecPosition {
    public String client;
    public String union;
    public Integer secid;
    public Integer market;
    public String shortname;
    public String seccode;
    public Integer saldoin;
    public Integer saldomin;
    public Integer bought;
    public Integer sold;
    public Integer saldo;
    public Integer ordbuy;
    public Integer ordsell;
}
