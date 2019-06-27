package com.jcg.selenium.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class SecondTest extends  TestBase {


    @Test
    public void GOOGLE1() {
        WebDriver driver = TLDriverFactory.getDriver();
        System.out.println("Google1 Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("GOOGLE1-TEST - driver: " + driver);
        System.out.println("Google1 Test's Page title is: " +  driver.getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals( driver.getTitle(), "Google");
        System.out.println("Google1 Test Ended! " + Thread.currentThread().getId());
    }

    @Test
    public void YANDEX1() {
        WebDriver driver = TLDriverFactory.getDriver();
        System.out.println("Yandex Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.yandex.com");
        System.out.println("YANDEX-TEST - driver: " + driver);
        System.out.println("Yandex Test's Page title is: " +  driver.getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals( driver.getTitle(), "Яндекс");
        System.out.println("Yandex Test Ended! " + Thread.currentThread().getId());
    }
}
