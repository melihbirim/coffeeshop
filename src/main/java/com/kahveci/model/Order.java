package com.kahveci.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
    private String beverage;
    private String extra;
    private String syrup;
    private String size;

    public Order() {
    }

    public Order(String beverage, String extra, String syrup, String size) {
        this.beverage = beverage;
        this.extra = extra;
        this.syrup = syrup;
        this.size = size;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getSyrup() {
        return syrup;
    }

    public void setSyrup(String syrup) {
        this.syrup = syrup;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
