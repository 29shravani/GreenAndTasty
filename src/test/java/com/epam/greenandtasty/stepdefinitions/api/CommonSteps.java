package com.epam.greenandtasty.stepdefinitions.api;

import com.epam.greenandtasty.context.APIContext;
import com.epam.greenandtasty.utils.*;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class CommonSteps {
    private static final Logger logger = LogManager.getLogger(CommonSteps.class);
    private final APIContext apiContext;

    public CommonSteps(APIContext apiContext) {
        this.apiContext = apiContext;
    }

    @Given("I am logged in as a customer with {string} {string}")
    public void customerLogin(String email, String password) {
        String token = AuthUtil.login(email, password);
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("Login failed for customer: " + email);
        }
        apiContext.setAuthToken(token);
        logger.info("Logged in as customer {}", email);
    }

    @Given("I am logged in as a waiter with {string} {string}")
    public void waiterLogin(String email, String password) {
        String token = AuthUtil.login(email, password);
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("Login failed for waiter: " + email);
        }
        apiContext.setAuthToken(token);
        logger.info("Logged in as waiter {}", email);
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        logger.info("Sending GET request to endpoint: {}", endpoint);
        apiContext.setResponse(RequestHelper.get(endpoint));
        logger.info("Received response: {}", apiContext.getResponse().asString());
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        ResponseValidator.validateStatusCode(apiContext.getResponse(), expectedStatusCode);
    }

    @And("the response should contain message {string}")
    public void theResponseShouldContainMessage(String expectedMessage) {
        ResponseValidator.validateResponseMessage(apiContext.getResponse(), expectedMessage);
    }

    @And("the response should match the JSON schema {string}")
    public void theResponseShouldMatchTheJSONSchema(String filename) {
        apiContext.getResponse().then().assertThat().body(matchesJsonSchemaInClasspath(filename));
    }

    @And("the response should contain error field {string} with value {string}")
    public void validateErrorMessage(String fieldName, String expectedValue) {
        apiContext.getResponse().then().assertThat().body(fieldName, equalTo(expectedValue));
        logger.info("Validated error field '{}' with expected value '{}'", fieldName, expectedValue);
    }


    @When("I send a GET request to {string} with authentication")
    public void iSendAGETRequestToWithAuthentication(String endpoint) {
        logger.info("Sending authenticated GET request to {}", endpoint);
        apiContext.setResponse(RequestHelper.get(endpoint, apiContext.getAuthToken()));
        logger.info("Received response: {}", apiContext.getResponse().asString());
    }
}