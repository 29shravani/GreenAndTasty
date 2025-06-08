package stepdefinations.api;

import context.APIContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.RequestHelper;

public class UserLoginSteps {

    private APIContext apiContext;

    private static final Logger logger = LogManager.getLogger(UserLoginSteps.class);

    public UserLoginSteps(APIContext apiContext) {
        this.apiContext = apiContext;
    }

    @Given("existing user trying to login")
    public void existing_user_trying_to_login() {
        logger.info("Step: existing user trying to login");
    }

    @When("I send a POST request to {string} with username {string} and {string}")
    public void iSendAPOSTRequestToWithUsernameAnd(String endPoint, String email, String password) {
        logger.info("Sending POST request to endpoint: {} with email: {}", endPoint, email);

        UserLogin userLogin = new UserLogin.UserBuilder()
                .setEmail(email)
                .setPassword(password)
                .builder();

        apiContext.setResponse(RequestHelper.post(endPoint, userLogin));

        logger.info("POST request sent successfully. Endpoint: {}", endPoint);
        logger.debug("Response: {}", apiContext.getResponse().asString());
    }

    @And("the response should contain a valid authentication token")
    public void theResponseShouldContainAValidAuthenticationToken() {
        String accessToken = apiContext.getResponse().jsonPath().get("data.accessToken");
        Assert.assertNotNull(accessToken, "Access token should not be null");
        Assert.assertFalse(accessToken.isEmpty(), "Access token should not be empty");
        apiContext.setAccessToken(accessToken);
        logger.info("Access token verified successfully");
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBeStatus_code(int expectedStatusCode) {
        int actualStatusCode = apiContext.getResponse().getStatusCode();
        logger.info("Verifying status code: expected = {}, actual = {}", expectedStatusCode, actualStatusCode);
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    @And("the username of user should be {string}")
    public void theUsernameOfUserShouldBe(String expectedUsername) {
        String actualUsername = apiContext.getResponse().jsonPath().getString("data.username");
        logger.info("Verifying username: expected = {}, actual = {}", expectedUsername, actualUsername);
        Assert.assertEquals(actualUsername, expectedUsername);
    }

    @And("the role of user should be {string}")
    public void theRoleOfUserShouldBe(String expectedRole) {
        String actualRole = apiContext.getResponse().jsonPath().getString("data.role");
        logger.info("Verifying role: expected = {}, actual = {}", expectedRole, actualRole);
        Assert.assertEquals(actualRole, expectedRole);
    }

    @And("the response should contain message {string}")
    public void theResponseShouldContainMessage(String expectedMessage) {
        String actualMessage = apiContext.getResponse().jsonPath().getString("message");
        logger.info("Verifying message: expected = {}, actual = {}", expectedMessage, actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
