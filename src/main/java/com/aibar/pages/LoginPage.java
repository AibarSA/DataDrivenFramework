package com.aibar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void doLogin(String userName, String password){
        driver.findElement(By.xpath(""));
    }
}
