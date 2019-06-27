package com.jcg.selenium.junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchTest extends TestBase {

    public GoogleSearchTest(MutableCapabilities capabilities) {
       super(capabilities);
    }

//    public GoogleSearchTest(){
//        super(new ChromeOptions());
//    }

    @Test
    public void openGoogle() {
        WebDriver webDriver = getDriver();
        webDriver.navigate().to("http://www.google.com");
        Assert.assertEquals("Google", webDriver.getTitle());
    }

    @Test
    public void enterGoogleSearchAndViewResults() throws InterruptedException {
        WebDriver webDriver = getDriver();


        webDriver.get("http://www.google.com");
        Thread.sleep(5000);
        //System.out.println(webDriver.getPageSource());
        WebElement searchText = webDriver.findElement(By.xpath("//html/body/div[1]/div[3]/form/div[2]/div/div[1]/div/div[1]/input"));
        searchText.sendKeys("hi");
        Thread.sleep(2000);
        By searchLocator = By.xpath("//html/body/div[1]/div[3]/form/div[2]/div/div[2]/div[2]/div[2]/center/input[1]");
        WebElement searchButton = webDriver.findElement(searchLocator);
        searchButton.click();
        Assert.assertEquals("hi - Пошук Google", webDriver.getTitle());
    }


}
