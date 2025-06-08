@signup @ui
Feature: SignUp Feature

  Background: As a User
    Given I am a user and I am on HomePage
    When I click on Sign In button on Home Page
    And I am redirected to sign-in page
    And I click on create new account link on SignIn Page
    And I am redirected to sign-Up page
  @Smoke
  Scenario Outline: Successful SignUp with valid credentials
    And I enter "<firstName>" "<lastName>" "<email>" "<password>"
    And I click on create new account button on SignUp Page
    Then I should be redirected to the Sign In page
    Examples:
      | firstName | lastName | email | password |
      | Mahendra  |Dhoni     | dhonims7@gmail.com | NewPass@123|
      | Shravan  |  Malhotra   | shravansumo10@gmail.com | NewPass@123|



