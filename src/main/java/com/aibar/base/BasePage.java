package com.aibar.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToBeClickable(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForVisibilityOfAllElementsLocatedBy(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForPresenceOfElementLocated(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.valueOf(webElement))));
    }

    public void waitForListElements(List<WebElement> webElements){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }
}
