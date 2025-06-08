package com.epam.greenandtasty.stepdefinitions.api;

import com.epam.greenandtasty.context.APIContext;
import com.epam.greenandtasty.models.UserRegistration;
import com.epam.greenandtasty.utils.ApiReader;
import com.epam.greenandtasty.utils.RequestHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


public class UserRegistrationSteps {
    private final APIContext apiContext;

    public UserRegistrationSteps(APIContext apiContext) {
        this.apiContext = apiContext;
    }








    @When("I send a POST request to {string} with firstName {string}, lastName {string}, email {string}, and password {string}")
    public void iSendAPOSTRequestToWithFirstNameLastNameEmailAndPassword(String endpoint, String firstName, String lastName, String email, String password) {
        UserRegistration user = new UserRegistration.UserBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .builder();

        apiContext.setResponse(RequestHelper.post(endpoint, user));

    }
}
