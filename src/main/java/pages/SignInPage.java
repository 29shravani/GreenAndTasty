package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[.='Sign In to Your Account']")
    private WebElement heading;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[.='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[.='Create an Account']")
    private WebElement createAnAccountLink;

    public void enterEmailAndPassword(String email, String password){
        waitForElement(emailField).sendKeys(email);
        waitForElement(passwordField).sendKeys(password);
    }

    public void clickOnSignIn(){
        waitForElement(signInButton).click();

    }

    public void clickOnCreateAnAccountLink(){
        waitForElement(createAnAccountLink).click();
    }
    public WebElement getHeading(){
        return waitForElement(heading);
    }






}
