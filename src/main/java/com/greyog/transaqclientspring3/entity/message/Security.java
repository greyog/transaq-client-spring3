package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.*;
import lombok.NoArgsConstructor;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class Security {
    public String sec_tz;
    public String seccode;
    public String instrclass;
    public String currency;
    public String board;
    public String shortname;
    public Integer decimals;
    public Integer market;
    public String sectype;
    public Opmask opmask;
    public Double minstep;
    public Integer lotsize;
    public Integer lotdivider;
    public Integer poInteger_cost;
    public Integer quotestype;
    @XmlAttribute
    public Integer secid;
    @XmlAttribute
    public Boolean active;
    public String text;

    public Security(String seccode, String board) {
        this.seccode = seccode;
        this.board = board;
    }
}
