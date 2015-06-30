package com.kahveci.model;

public enum Syrup implements Addable {
    NONE("None", 0), CARAMEL("Caramel", 1), CINNAMON("Cinnamon", 1), VANILLA("Vanilla", 2), CHOCOLATE("Chocolate", 2);
    final String name;
    final double price;

    Syrup(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
