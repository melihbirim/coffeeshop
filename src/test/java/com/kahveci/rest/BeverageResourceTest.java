package com.kahveci.rest;

import com.kahveci.dao.BeverageService;
import com.kahveci.model.Beverage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeverageResourceTest {
    Logger logger = Logger.getLogger(this.getClass().getName());


    BeverageService beverageService;

    @Before
    public void before() {
        beverageService = BeverageService.instance;
    }

    @Test
    public void testAllBeverages() {
        Beverage[] all = beverageService.getAll();
        Assert.assertNotNull(all);
        Assert.assertEquals(all.length, 7);
    }

    @Test
    public void testInquire() {
        String name = "Tea";
        Beverage inquire = beverageService.inquire(name);
        Assert.assertNotNull(inquire);
        Assert.assertEquals(inquire.getName(), name);
    }


}