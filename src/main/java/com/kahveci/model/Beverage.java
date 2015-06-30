package com.kahveci.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Beverage {
    private String name;
    private Type type;
    private Set<Option> options;
    private Set<Extra> extras;
    private List<Size> sizes;
    private double price;

    public Beverage() {
    }

    public Beverage(String name, Type type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.options = Sets.newHashSet();
        this.extras = Sets.newHashSet();
        this.sizes = Lists.newArrayList();
    }

    public Beverage addOption(Option option) {
        options.add(option);
        return this;
    }

    public Beverage addAllOptions() {
        Collections.addAll(options, Option.values());
        return this;
    }

    public Beverage addSize(Size size) {
        sizes.add(size);
        return this;
    }

    public Beverage addAllSizes() {
        Collections.addAll(sizes, Size.values());
        return this;
    }

    public Beverage addExtra(Extra extra) {
        extras.add(extra);
        return this;
    }

    public Beverage addAllExtras() {
        Collections.addAll(extras, Extra.values());
        return this;
    }

    public String getName() {
        return name;
    }
}



