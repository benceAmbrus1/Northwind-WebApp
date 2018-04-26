package com.codecool.web.model;

public class Task4 extends AbstractTask{

    private Short[] orders;

    public Task4( String company, Short[] orders) {
        super( company);
        this.orders = orders;
    }

    public Short[] getOrders() {
        return orders;
    }
}
