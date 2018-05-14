package com.aibar.utilities;

import com.aibar.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TestUtil extends BaseTest {

    public static  void captureScreenshot(WebDriver driver, String methodName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),
                    new File("src/main/resources/ScreenShots/" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Screenshot for {} taken", methodName);

    }
}
