package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@XmlRootElement
public class MyFortsPositions implements Loggable{
    @Getter
    @XmlElement
    private List<MyFortsPosition> positions;
    @XmlElement
    private String timeStamp;

    public MyFortsPositions() {
        this.positions = new ArrayList<>();
    }

    public MyFortsPositions(List<FortsPosition> fortsOptionsPosition) {
        positions = fortsOptionsPosition.stream()
                .map(MyFortsPosition::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "MyFortsPositions{" +
                "positions=" +
                positions.stream()
                        .map(MyFortsPosition::getFortsPosition)
                        .map(fortsPosition -> "["+fortsPosition.seccode+" * " + fortsPosition.totalnet + "]")
                        .collect(Collectors.joining(", "))
                + '}';
    }

    @Override
    public void log() {
        log.info(this.toString());
    }
}
