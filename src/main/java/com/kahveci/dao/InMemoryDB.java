package com.kahveci.dao;

import com.kahveci.model.Beverage;
import com.kahveci.model.Extra;
import com.kahveci.model.Size;
import com.kahveci.model.Type;

import java.util.HashMap;
import java.util.Map;

public enum InMemoryDB {
    instance; // singleton impl

    private final Map<String, Beverage> beverages = new HashMap<>();

    private InMemoryDB() {
        // TODO create beverages here
        add(new Beverage("Latte", Type.ESPRESSO, 5.75D).addAllOptions().addAllSizes().addAllExtras());
        add(new Beverage("Mocha", Type.ESPRESSO, 6.25D).addAllOptions().addAllSizes().addAllExtras());
        add(new Beverage("Capucchino", Type.ESPRESSO, 6.75D).addAllOptions().addAllSizes().addAllExtras());
        add(new Beverage("Macchiato", Type.ESPRESSO, 7.55D).addAllOptions().addAllSizes().addAllExtras());
        add(new Beverage("Filter Coffee", Type.FILTERED, 4.75D).addSize(Size.TALL));
        add(new Beverage("Tea", Type.TEA, 2.50D).addAllOptions().addAllSizes().addExtra(Extra.EXTRA_MILK));
        add(new Beverage("Chai Tea Latte", Type.TEA, 6.50D).addAllOptions().addAllSizes().addExtra(Extra.EXTRA_MILK));
    }

    public Map<String, Beverage> getData() {
        return beverages;
    }

    public Beverage add(Beverage beverage) {
        return beverages.put(beverage.getName(), beverage);
    }

    public Beverage delete(String name) {
        return beverages.remove(name);
    }


}
