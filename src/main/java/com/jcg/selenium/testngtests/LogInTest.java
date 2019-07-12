package com.jcg.selenium.testngtests;

import com.jcg.selenium.model.User;
import com.jcg.selenium.pages.LoginPage;
import com.jcg.selenium.utils.PredefinedTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class LogInTest extends BaseTest {

    private static final String USER_NAME = "RKEZX7ZjJiSqW4sFqDLH/A==";
    private static final String PASSWORD_NAME = "c8kUSt3WL3YBFs3PaQ7aEQ==";

    @Autowired
    LoginPage loginPage;

    @Test
    public void logInTest() throws MalformedURLException, InterruptedException {

        User user = new User();
        user.setUsername(PredefinedTextEncryptor.decrypt(USER_NAME));
        user.setPassword(PredefinedTextEncryptor.decrypt(PASSWORD_NAME));
        loginPage.login(user);
        Thread.sleep(10000);
        System.out.println("Hello!");

    }
}
