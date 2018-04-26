package com.codecool.web.model;

public class Task1 extends AbstractTask {

    private String product;

    public Task1( String company, String product) {
        super(company);
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
}
