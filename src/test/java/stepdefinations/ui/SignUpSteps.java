package stepdefinations.ui;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.SignInPage;
import pages.SignUpPage;

public class SignUpSteps {
    private TestContext testContext;
    private SignInPage signInPage;
    private SignUpPage signUpPage;
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);

    public SignUpSteps(TestContext testContext) {
        this.testContext = testContext;
        signInPage = new SignInPage(testContext.getDriver());
    }
    @And("I click on create new account link on SignIn Page")
    public void I_click_on_create_new_account_link_on_SignIn_Page(){
        signInPage.clickOnCreateAnAccountLink();
        logger.info("I click on create new account link on sign in page");

    }


    @And("I enter {string} {string} {string} {string}")
    public void iEnter(String firstName, String lastName, String email, String password) {
        signUpPage.fillDetailsInSignUp(firstName, lastName, email, password, password);
        logger.info("I enter details on sign in page {} {} {}", firstName, lastName, email);

    }

    @And("I am redirected to sign-Up page")
    public void iAmRedirectedToSignUpPage() {
        signUpPage = new SignUpPage(testContext.getDriver());
        logger.info("I  on sign Up page");


    }


    @And("I click on create new account button on SignUp Page")
    public void iClickOnCreateNewAccountButton() {
        signUpPage.clickOnCreateAnAccountBtn();
        logger.info("I click on create new account button on SignUp Page");

    }

    @Then("I should be redirected to the Sign In page")
    public void iShouldBeRedirectedToTheSignInPage() {
        Assert.assertTrue(signInPage.getHeading()!=null && signInPage.getHeading().getText().equals("Sign In to Your Account"));

        //Assert.assertEquals(signInPage.getHeading().getText(),"Sign In to Your Account");
    }
}
