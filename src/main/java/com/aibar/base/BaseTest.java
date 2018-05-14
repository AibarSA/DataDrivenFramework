package com.aibar.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties objectRepository = new Properties();
    public static Logger logger = LogManager.getLogger("Logger");
    public static WebDriverWait wait;

    @BeforeSuite
    public void setUp(){

        if (driver == null){
            try {
                config.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\Config.properties"));
                logger.debug("config file loaded.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (config.getProperty("browser").equalsIgnoreCase("firefox")){

//            System.setProperty("webdriver.firefox.marionette",
// System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\geckodriver.exe");
//            driver = new FirefoxDriver();
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //Location where Firefox is installed

            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("moz:firefoxOptions", options);
            //set more capabilities as per your requirements

             driver = new FirefoxDriver(capabilities);




        } else if (config.getProperty("browser").equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/executables/chromedriver.exe");
            driver = new ChromeDriver();

        }

        driver.get(config.getProperty("url"));
        logger.debug("navigated to: " + config.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitlyWait")), TimeUnit.SECONDS);
    }



    @AfterSuite
    public void TearDown(){
        if (driver!=null) {
            driver.quit();
        }
        logger.debug("test execution completed.");

    }
}
