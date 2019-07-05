package com.jcg.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.util.concurrent.TimeUnit;

@Configuration
@Profile("chrome")
public class ChromeDriver implements DesktopDriver {

    @Autowired
    Environment environment;

    @Override
    public WebDriver desktopDriver() {
        System.out.println("Getting Chrome driver ..");
        TLDriverFactory.getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return TLDriverFactory.getDriver();

    }

    public void initiateDriver() {
        System.out.println("Initiate Chrome driver..");
        TLDriverFactory.setDriver(environment.getActiveProfiles()[0]);

    }


}
