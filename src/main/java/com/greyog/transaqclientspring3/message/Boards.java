package com.greyog.transaqclientspring3.message;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Boards {
    public List<Board> board = new ArrayList<>();
}
