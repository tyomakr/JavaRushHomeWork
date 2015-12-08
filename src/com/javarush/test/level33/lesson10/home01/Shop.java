package com.javarush.test.level33.lesson10.home01;


import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name="shop")
@XmlRootElement
public class Shop
{
    @XmlElementWrapper(name="goods", nillable = true)
    public List<String> names = new ArrayList<>();
    public int count;
    public String profit;
    public List<String> secretData = new ArrayList<>();
}