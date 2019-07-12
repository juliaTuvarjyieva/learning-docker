package com.jcg.selenium.driver;

import org.openqa.selenium.WebDriver;

public interface DesktopDriver {

    WebDriver desktopDriver();
    void initiateDriver();

    default void quiteDriver() {
        TLDriverFactory.quiteDriver();
    }

}
