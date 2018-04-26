package com.codecool.web.model;

public class Task5 extends AbstractTask{

    private String unitName;
    private int unitPrice;

    public Task5(String company, String unitName, int unitPrice) {
        super( company);
        this.unitName = unitName;
        this.unitPrice = unitPrice;
    }

    public String getUnitName() {
        return unitName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
