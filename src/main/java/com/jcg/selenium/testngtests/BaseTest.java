package com.jcg.selenium.testngtests;

import com.jcg.selenium.driver.DesktopDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    private static final String BASE_URL = "https://koala-apps.idtmessaging.com/configuration-admin-development/index.html";

    @Autowired
    protected DesktopDriver desktopDriver;

    @BeforeMethod
    public void initiateDriver() {
        desktopDriver.initiateDriver();
        desktopDriver.desktopDriver().get(BASE_URL);
    }

    @AfterMethod
    public void quiteDriver() {
        desktopDriver.quiteDriver();
    }

}
