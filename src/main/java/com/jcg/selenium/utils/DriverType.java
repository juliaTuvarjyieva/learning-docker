package com.jcg.selenium.utils;

public enum DriverType {

    CHROME ("chrome"), FIREFOX("firefox");


    private String driverType;

    private DriverType (String driverType) {
        this.driverType = driverType;
    }

    public String getDriverType() {
        return driverType;
    }
}
