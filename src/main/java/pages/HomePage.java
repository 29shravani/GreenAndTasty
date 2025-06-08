package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[.='Sign In']")
    private WebElement signInButton;

    public void clickOnSignIn(){
        waitForElement(signInButton).click();
    }


}
