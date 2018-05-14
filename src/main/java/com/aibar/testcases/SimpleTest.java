package com.aibar.testcases;

import com.aibar.base.BaseTest;
import com.aibar.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {

    @Test
    public void simpleTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.goToFlights().bookAFlight("Almaty, Kazakhstan (ALA-Almaty Intl.)","San Francisco, California","05/16/2018","06/11/2018");
    }
}
