package com.kahveci.dao;

public enum OrderService {
    instance; // singleton impl
    private InMemoryDB db; // TODO use @Inject , injection of the DB
}
