package com.jcg.selenium.driver;

import com.jcg.selenium.testngtests.OptionsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TLDriverFactory {

    private static OptionsManager optionsManager = new OptionsManager();
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static synchronized void setDriver(String profile) {

        if (profile.equals("firefox")) {
            //For Local Usage
            //tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(optionsManager.getFirefoxOptions()));

            //For Grid Usage
            try {

                tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getFirefoxOptions()));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (profile.equals("chrome")) {
            //For Local Usage
            //tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

            //For Grid Usage
            try {
                tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getChromeOptions()));
                tlDriver.get().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized WebDriverWait getWait (WebDriver driver) {
        return new WebDriverWait(driver,10);
    }


    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static synchronized void quiteDriver() {
         tlDriver.get().quit();
    }
}
