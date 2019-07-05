package com.jcg.selenium.testngtests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {


    @Test
    public void GOOGLE0() throws Exception {
        System.out.println("Google0 Test Started! " + Thread.currentThread().getId());
        desktopDriver.desktopDriver().navigate().to("http://www.google.com");
        Thread.sleep(3000);
        System.out.println("Google0 Test's Page title is: " + desktopDriver.desktopDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(desktopDriver.desktopDriver().getTitle(), "Google");
        System.out.println("Google0 Test Ended! " + Thread.currentThread().getId());
    }

    @Test
    public void GOOGLE2() throws Exception {
        System.out.println("Google1 Test Started! " + Thread.currentThread().getId());
        desktopDriver.desktopDriver().navigate().to("http://www.google.com");
        Thread.sleep(3000);
        System.out.println("Google1 Test's Page title is: " + desktopDriver.desktopDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(desktopDriver.desktopDriver().getTitle(), "Google");
        System.out.println("Google1 Test Ended! " + Thread.currentThread().getId());
    }

    @Test
    public void GOOGLE3() throws Exception {
        System.out.println("Google3 Test Started! " + Thread.currentThread().getId());
        desktopDriver.desktopDriver().navigate().to("http://www.google.com");
        Thread.sleep(3000);
        System.out.println("Google3 Test's Page title is: " + desktopDriver.desktopDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(desktopDriver.desktopDriver().getTitle(), "Google");
        System.out.println("Google3 Test Ended! " + Thread.currentThread().getId());
    }

    @Test
    public void GOOGLE4() throws Exception {
        System.out.println("Google4Test Started! " + Thread.currentThread().getId());
        desktopDriver.desktopDriver().navigate().to("http://www.google.com");
        Thread.sleep(3000);
        System.out.println("Google4 Test's Page title is: " + desktopDriver.desktopDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(desktopDriver.desktopDriver().getTitle(), "Google");
        System.out.println("Google4 Test Ended! " + Thread.currentThread().getId());
    }
}
