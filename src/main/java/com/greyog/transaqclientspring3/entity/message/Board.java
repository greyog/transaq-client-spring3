package com.greyog.transaqclientspring3.entity.message;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Board {
    public String name;
    public int market;
    public int type;
    public String id;
    public String text;
}
