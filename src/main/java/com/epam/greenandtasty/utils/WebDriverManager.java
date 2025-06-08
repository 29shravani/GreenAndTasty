package com.epam.greenandtasty.utils;

import com.epam.greenandtasty.exceptions.WebDriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static com.epam.greenandtasty.utils.ConfigReader.getValue;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();

    private WebDriverManager() {
    }

    public static WebDriver getWebDriver(String browser) throws IOException {

        String executionEnvironment=Optional.ofNullable(getValue("execution_environment"))
                .orElse("local");

        if(executionEnvironment.equals("grid")){
            return getWebDriverInstanceForGrid(browser);
        }
        else{
            return getWebDriverInstanceForLocal(browser);
        }

    }

    private static WebDriver getWebDriverInstanceForLocal(String webDriverType) throws WebDriverNotFoundException{
        if (threadLocalWebDriver.get() == null) {
            threadLocalWebDriver.set(DriverFactory.createWebDriver(webDriverType));
        }
        return threadLocalWebDriver.get();
    }

    public static WebDriver getWebDriverInstanceForGrid(String browser) throws IOException {
        if (browser == null || browser.trim().isEmpty()) {
            throw new IllegalArgumentException("Browser type cannot be null or empty");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.trim().toLowerCase());
        return new RemoteWebDriver(new URL(ConfigReader.getValue("node_url")), capabilities);
    }

    public static void quitWebDriver() {
        WebDriver driver = threadLocalWebDriver.get();
        if (driver != null) {
            driver.quit();
            threadLocalWebDriver.remove();  // Ensures proper cleanup
        }
    }
}