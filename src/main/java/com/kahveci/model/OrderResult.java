package com.kahveci.model;

public class OrderResult {
    private Order order;
    private double price;

    public OrderResult(Order order, double price) {
        this.order = order;
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public double getPrice() {
        return price;
    }
}
