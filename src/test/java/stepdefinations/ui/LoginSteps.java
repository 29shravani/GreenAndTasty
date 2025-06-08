package stepdefinations.ui;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.CustomerDashBoard;
import pages.HomePage;
import pages.SignInPage;



public class LoginSteps {
    private TestContext uiContext;
    private HomePage homePage;
    private SignInPage signInPage;
    private CustomerDashBoard customerDashBoard;
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);


    public LoginSteps(TestContext uiContext){
        this.uiContext = uiContext;
    }

    @When("I click on Sign In button on Home Page")
    public void clickOnSignInOnHomePage(){
        homePage.clickOnSignIn();
        logger.info("I click on sign in on home Page");

    }

    @Given("I am a user and I am on HomePage")
    public void iAmAUserAndIAmOnHomePage() {
        homePage = new HomePage(uiContext.getDriver());
        logger.info("I am on home Page");
    }

    @And("I am redirected to sign-in page")
    public void iAmRedirectedToSignInPage() {
        signInPage = new SignInPage(uiContext.getDriver());
        logger.info("I am on Sign In Page");


    }

    @And("I enter {string} and {string}")
    public void iEnterAnd(String email, String password) {
        logger.info("I enter email, password");

        signInPage.enterEmailAndPassword(email, password);

    }

    @And("I click on Sign-in")
    public void iClickOnSignIn() {
        logger.info("I click sign in on Sign in Page");
        signInPage.clickOnSignIn();


    }

    @Then("I am logged in to page and redirect to Home Page should see Reservations tab")
    public void iAmLoggedInToPageAndRedirectToHomePageShouldSeeReservationsTab() {
        customerDashBoard = new CustomerDashBoard(uiContext.getDriver());
        Assert.assertTrue(customerDashBoard.verifyReservationsTabisVisible().isDisplayed());
    }

    @Then("I should not see the Reservations tab on the dashboard page")
    public void iShouldNotSeeTheReservationsTabOnTheDashboardPage() {
        customerDashBoard = new CustomerDashBoard(uiContext.getDriver());
        Assert.assertNull(customerDashBoard.verifyReservationsTabisVisible());
    }
}
