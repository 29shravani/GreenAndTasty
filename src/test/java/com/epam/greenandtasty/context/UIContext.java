package com.epam.greenandtasty.context;

import com.epam.greenandtasty.exceptions.WebDriverNotFoundException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class UIContext {
    private WebDriver driver;

    public UIContext() throws WebDriverNotFoundException, IOException {
    }

    public void setWebDriver(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getWebDriver(){
        return driver;
    }
}
