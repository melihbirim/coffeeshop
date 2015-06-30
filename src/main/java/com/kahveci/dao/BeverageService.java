package com.kahveci.dao;

import com.kahveci.model.Beverage;

import java.util.Collection;

public enum BeverageService {
    instance;

    private final InMemoryDB db = InMemoryDB.instance;// TODO use @Inject , injection of the DB

    public Beverage inquire(String name) {
        return db.getData().get(name);
    }

    public Beverage[] getAll() {
        Collection<Beverage> values = db.getData().values();
        return values.toArray(new Beverage[values.size()]);
    }

}
