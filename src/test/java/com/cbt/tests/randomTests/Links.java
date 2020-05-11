package com.cbt.tests.randomTests;

import com.cbt.utilities.Driver;

public class Links {

    public void setup(){
        Driver.getDriver("chrome").get("https://www.w3schools.com/");

    }

}
