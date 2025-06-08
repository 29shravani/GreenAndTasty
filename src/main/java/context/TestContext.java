package context;

import org.openqa.selenium.WebDriver;
import utils.driver.WebDriverManager;

public class TestContext {

    private WebDriver driver;

    public TestContext(){
        System.out.println("UI context constructor");
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

}
