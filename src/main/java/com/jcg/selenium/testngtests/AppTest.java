package com.jcg.selenium.testngtests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppTest {

    public static URL url;
    public static DesiredCapabilities capabilities;
    public static AndroidDriver driver;


    @BeforeSuite
    public void setupAppium() throws MalformedURLException {

        final String URL_STRING = "http://192.168.99.100:4723/wd/hub";
        url = new URL(URL_STRING);

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yahoo.mobile.client.android.weather.ui.onboarding.OnBoardingScreenActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, 90000);
        capabilities.setCapability(MobileCapabilityType.APP, "/opt/com.yahoo.mobile.client.android.weather_v1.18.0-91596211_Android-4.4.apk");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        driver = new AndroidDriver<>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.getBatteryInfo());
    }


    @Test(enabled = true)
    public void myFirstTest() throws InterruptedException {
        System.out.println(driver.getBatteryInfo());
    }
}
//6
