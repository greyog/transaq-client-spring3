package com.greyog.transaqclientspring3.entity.message;

import com.greyog.transaqclientspring3.component.OptionCodeParser;
import com.greyog.transaqclientspring3.entity.OptionType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

@XmlRootElement
public class MyFortsPosition {
    @Getter
    @XmlElement
    private FortsPosition fortsPosition;
    @XmlElement
    private double startPrice = 0;

    @Getter
    private String assetCode;
    private boolean isWeekOption;
    @Getter
    private OptionType optionType;
    @Getter
    private String futuresCode;
    @Getter
    private int strike;

    public MyFortsPosition(){};

    public MyFortsPosition(FortsPosition fortsPosition) {
        this.fortsPosition = fortsPosition;
        OptionCodeParser.parseFortsPosition(this);
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public void setIsWeekOption(boolean isWeekOption) {
        this.isWeekOption = isWeekOption;
    }

    public boolean getIsWeekOption() {
        return isWeekOption;
    }

    public void setOptionType(String optionType) {
        if( optionType.equalsIgnoreCase(OptionType.CALL.name())) {
            this.optionType = OptionType.CALL;
        } else if( optionType.equalsIgnoreCase(OptionType.PUT.name())) {
            this.optionType = OptionType.PUT;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setFuturesCode(String futuresCode) {
        this.futuresCode = futuresCode;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

}
