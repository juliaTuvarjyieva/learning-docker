package com.jcg.selenium.pages;

import com.jcg.selenium.driver.DesktopDriver;
import com.jcg.selenium.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    @Autowired
    private HomePage homePage;

    @Autowired
    DesktopDriver desktopDriver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//html/body/div[1]/div/div/div[2]/div/div/div/div[3]/button/div/div");


    public HomePage login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(desktopDriver.desktopDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)).sendKeys(username);
        desktopDriver.desktopDriver().findElement(passwordField).sendKeys(password);
        desktopDriver.desktopDriver().findElement(loginButton).click();
        return homePage;
    }

    public HomePage login(User user) {
        return login(user.getUsername(), user.getPassword());
    }

}
