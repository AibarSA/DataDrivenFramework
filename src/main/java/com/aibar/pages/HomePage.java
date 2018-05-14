package com.aibar.pages;

import com.aibar.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='tab-flight-tab-hp']")
    private WebElement flightTab;
    @FindBy(xpath = "//input[@id='flight-origin-hp-flight']")
    private WebElement fromCity;
    @FindBy(xpath = "//input[@id='package-destination-hp-package']")
    private WebElement toCity;
    @FindBy(xpath = "//input[@id='package-departing-hp-package']")
    private WebElement departFlight;
    @FindBy(xpath = "//input[@id='package-returning-hp-package']")
    private WebElement returnFlight;
    @FindBy(xpath = "//button[@id='search-button-hp-package']")
    private WebElement search;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage goToFlights(){
        flightTab.click();
        return this;
    }

    public void goToHotels(){}

    public void goToBundleAndSave(){}

    public void bookAFlight(String from, String to, String departing, String returning){
        waitForVisibilityOfAllElementsLocatedBy(fromCity);
        fromCity.sendKeys(from);
        waitForVisibilityOfAllElementsLocatedBy(toCity);
        toCity.sendKeys(to);
        departFlight.sendKeys(departing);
        returnFlight.sendKeys(returning);
        search.click();
    }
}
