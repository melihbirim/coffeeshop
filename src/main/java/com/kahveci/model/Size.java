package com.kahveci.model;

public enum Size {
    SHORT("Short", 0), TALL("Tall", 1), GRENDE("Grende", 2), VENTI("Venti", 3);
    final String name;
    final double price;

    Size(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

