package com.jcg.selenium.driver;

import com.jcg.selenium.driver.DesktopDriver;
import com.jcg.selenium.driver.TLDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;


public class InvokedMethodListener implements IInvokedMethodListener {

  @Autowired
  DesktopDriver desktopDriver;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            System.out.println("Test Method BeforeInvocation is started. " + Thread.currentThread().getId());
           // TLDriverFactory.setDriver();
            desktopDriver.initiateDriver();
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            System.out.println("Test Method AfterInvocation is started. " + Thread.currentThread().getId());
            WebDriver driver = TLDriverFactory.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
