//package com.jcg.selenium.driver;
//
//import com.jcg.selenium.testngtests.OptionsManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.springframework.stereotype.Service;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//@Service
//public class WebDriverGenerator {
//
//    private static OptionsManager optionsManager = new OptionsManager();
//
//    public WebDriver webDriver() throws MalformedURLException {
//        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getChromeOptions());
//
//
//    }
//
//
//}
