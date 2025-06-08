package hooks;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import utils.ConfigReader;
import utils.driver.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.ScreenShotUtil.captureViewPortScreenShot;

public class UIHooks {

    private TestContext uiContext;

    public UIHooks(TestContext uiContext){
        System.out.println("UI Hooks constructor");
        this.uiContext = uiContext;
    }

//    @Before("@ui")
//    public void setUpDriver(){
//        WebDriverManager.setWebDriver();
//        uiContext.setDriver(WebDriverManager.getWebDriver());
//        uiContext.getDriver().get(ConfigReader.getBaseUrl());
//    }

    @Before("@ui")
    public void setUp() throws MalformedURLException {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("chrome")) {
            uiContext.setDriver(new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions()));
        } else if (browser.equals("firefox")) {
            uiContext.setDriver(new RemoteWebDriver(new URL("http://localhost:4444"), new FirefoxOptions()));
        }
        uiContext.getDriver().get(ConfigReader.getBaseUrl());
    }

    @After("@ui")
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            attachScreenshot(uiContext.getDriver());
        }
       WebDriverManager.quitDriver();
        uiContext.getDriver().quit();
        uiContext.setDriver(null);
    }
    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}