package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@XmlRootElement
public class Positions implements Loggable {

    @XmlElement(name = "forts_position")
    public List<FortsPosition> fortsPosition = new ArrayList<>();

    @XmlElement(name = "forts_money")
    public FortsMoney fortsMoney;

    @XmlElement(name = "sec_position")
    public List<SecPosition> secPositions = new ArrayList<>();

    @XmlElement(name = "money_position")
    public MoneyPosition moneyPosition;

    @Override
    public void log() {
        log.info(this.toString());
    }

    @Override
    public String toString() {
        return "Positions: fortsPosition=%s, fortsMoney=%s, secPositions=%s, moneyPositions=%s"
                .formatted(fortsPosition.toString(),
                        fortsMoney == null ? "no forts money" : fortsMoney.toString(),
                        secPositions.toString(),
                        moneyPosition == null ? "no moneyPosition" : moneyPosition.toString());
    }
}
