package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerDashBoard extends BasePage{


    public CustomerDashBoard(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Reservations']")
    private WebElement reservationsTab;

    public WebElement verifyReservationsTabisVisible(){
        return waitForElement(reservationsTab);
    }

}
