package com.greyog.transaqclientspring3.service;

import com.greyog.transaqclientspring3.component.Server;
import com.greyog.transaqclientspring3.entity.message.FortsMoney;
import com.greyog.transaqclientspring3.entity.message.FortsPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private Server server;

    @Override
    public List<FortsPosition> getFortsPositions() {
        return server.getPositions().fortsPosition;
    }

    @Override
    public FortsPosition getFortsPositionBySecCode(String secCode) {
        return server.getPositions().fortsPosition.stream()
                .filter(fortsPosition -> fortsPosition.seccode.equals(secCode))
                .findFirst().orElseThrow();
    }

    @Override
    public List<FortsPosition> getFortsPositionsByBaseSecCode(String baseSecCode) {
        return null;
    }

    @Override
    public FortsMoney getFortsMoney() {
        return server.getPositions().fortsMoney;
    }
}
