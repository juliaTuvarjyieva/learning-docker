package com.jcg.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Profile("firefox")
public class FirefoxDriver implements DesktopDriver {

    @Autowired
    Environment environment;

    @Override
    public WebDriver desktopDriver() {
        System.out.println("Getting Firefox driver");
        TLDriverFactory.getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        return TLDriverFactory.getDriver();

    }

    public void initiateDriver() {
        System.out.println("Initiate firefox driver");
        TLDriverFactory.setDriver(environment.getActiveProfiles()[0]);

    }

}
