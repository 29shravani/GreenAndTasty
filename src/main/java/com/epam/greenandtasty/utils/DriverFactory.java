package com.epam.greenandtasty.utils;

import com.epam.greenandtasty.exceptions.WebDriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    private DriverFactory() {}

    public static WebDriver createWebDriver(String browser) throws WebDriverNotFoundException {
        return switch (browser.trim().toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "safari" -> new SafariDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new WebDriverNotFoundException("Unsupported WebDriver type: " + browser);
        };
    }

}
