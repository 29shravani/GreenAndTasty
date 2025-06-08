@signin @ui
Feature: Login Feature
  Background:
    Given I am a user and I am on HomePage
    When I click on Sign In button on Home Page
    And I am redirected to sign-in page
  @Smoke
  Scenario: Successful login with valid credentials
    And I enter "john.doe@example.com" and "NewPass@123"
    And I click on Sign-in
    Then I am logged in to page and redirect to Home Page should see Reservations tab
  @Regression
  Scenario: UnSuccessful login with Invalid credentials
    And I enter "john.doe@example.com" and "NewPass@12"
    And I click on Sign-in
    Then I should not see the Reservations tab on the dashboard page
