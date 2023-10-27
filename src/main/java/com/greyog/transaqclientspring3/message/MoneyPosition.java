package com.greyog.transaqclientspring3.message;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
public class MoneyPosition {
    public String currency;
    public String client;
    public String union;
    public Markets markets;
    public String asset;
    public String shortname;
    public BigDecimal saldoin;
    public BigDecimal bought;
    public BigDecimal sold;
    public BigDecimal saldo;
    public BigDecimal ordbuy;
    public BigDecimal ordbuycond;
    public BigDecimal comission;
}
