package com.greyog.transaqclientspring3.message;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement
public class MyFortsPositions {
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
}
