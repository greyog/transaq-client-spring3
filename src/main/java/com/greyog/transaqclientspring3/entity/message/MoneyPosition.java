package com.greyog.transaqclientspring3.entity.message;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Slf4j
@ToString
@XmlRootElement
public class MoneyPosition implements Loggable{
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

    @Override
    public void log() {
        log.info(this.toString());
    }
}
