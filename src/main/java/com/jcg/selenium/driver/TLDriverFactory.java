package com.jcg.selenium.driver;

import com.jcg.selenium.constants.PathConstants;
import com.jcg.selenium.testngtests.OptionsManager;
import com.jcg.selenium.utils.AuthStorage;
import com.jcg.selenium.utils.DriverType;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TLDriverFactory {

    private static OptionsManager optionsManager = new OptionsManager();
    private static ThreadLocal<MobileDriver> tlDriver = new ThreadLocal<>();

    public static synchronized void setDriver(String profile){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android");
        caps.setCapability("udid", "9DS8Z9AMZL89VCSW");
        caps.setCapability("browserName", "Chrome");
        //Get the IP Address of boot2docker
        //docker inspect $(docker ps -q) | grep IPA
        try {
            tlDriver.set(new AndroidDriver<MobileElement>(new URL("http://172.19.0.3:4723/wd/hub"), caps));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

//        if (profile.equals(DriverType.FIREFOX.getDriverType())) {
//            if (!AuthStorage.isDockerRun()) {
//                System.setProperty(PathConstants.FIREFOX_DRIVER, PathConstants.FIREFOХ_PATH);
//                //tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(optionsManager.getFirefoxOptions()));
//                tlDriver = ThreadLocal.withInitial(() -> new AndroidDriver<>(optionsManager.getFirefoxOptions()));
//            } else {
//                try {
//                    tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getFirefoxOptions()));
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//            }
//        } else if (profile.equals(DriverType.CHROME.getDriverType())) {
//            if (!AuthStorage.isDockerRun()) {
//                System.setProperty(PathConstants.CHROME_DRIVER, PathConstants.CHROME_PATH);
//                tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
//            } else {
//                try {
//                    tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getChromeOptions()));
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//        tlDriver.get().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    public static synchronized WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, 10);
    }


    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static synchronized void quiteDriver() {
        tlDriver.get().quit();
    }
}
