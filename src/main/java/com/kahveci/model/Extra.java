package com.kahveci.model;

public enum Extra implements Addable {
    NONE("None", 0), WHIPPED("Whipped Cream", 1), NO_WHIPPED("No Whipped Cream", 1), EXTRA_MILK("Extra Milk", 2);
    final String name;
    final double price;

    Extra(String name, double price) {
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
