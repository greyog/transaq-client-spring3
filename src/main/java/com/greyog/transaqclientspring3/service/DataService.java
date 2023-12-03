package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.entity.message.FortsMoney;
import com.greyog.transaqclientspring3.entity.message.FortsPosition;

import java.util.List;

public interface DataService {

    List<FortsPosition> getAllFortsPositions();
    FortsPosition getFortsPositionBySecCode(String secCode);
    List<FortsPosition> getFortsPositionsByBaseSecCode(String baseSecCode);

    FortsMoney getFortsMoney();

}
