package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShotUtil {
    public static void captureViewPortScreenShot(String testMethod, WebDriver driver) {
        Date date = new Date();
        long time = date.getTime();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = "target/screenshots" + time + " - " + testMethod + ".png";
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
