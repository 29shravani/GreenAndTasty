package utils.driver;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static void setWebDriver(){
        DriverFactory driverFactory = new DriverFactory();
        webDriverThreadLocal.set(driverFactory.createWebDriver(ConfigReader.getBrowser()));
    }
    public static WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }
    public static void quitDriver(){
        if(webDriverThreadLocal.get()==null)
            return;
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();

    }


}
