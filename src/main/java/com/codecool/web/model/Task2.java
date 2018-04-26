package com.codecool.web.model;

public class Task2 extends AbstractTask{

    private int numberOfProd;

    public Task2(String company, int numberOfProd) {
        super( company);
        this.numberOfProd = numberOfProd;
    }

    public int getNumberOfProd() {
        return numberOfProd;
    }
}
