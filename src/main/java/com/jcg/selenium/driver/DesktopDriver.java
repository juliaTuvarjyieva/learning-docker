package com.jcg.selenium.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;


public interface DesktopDriver {

    WebDriver desktopDriver() throws MalformedURLException;

    void initiateDriver();
}
