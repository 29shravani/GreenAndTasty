@ui @waiterReservationUI
Feature: Waiter Page
  As a waiter
  I want to be able to manage reservations
  So that I can efficiently handle customer bookings

  Background: Waiter login
    Given I am on the Home page
    And I click on the Sign In button on HomePage
    And I enter "aashijain06@gmail.com" into the Email field
    And I enter "Aashi@123" into the Password field
    And I click on the Sign In button


  @smoke
  Scenario: Verify Waiter can access reservation management screen
    When Waiter navigates to reservation management panel
    Then Waiter sees reservation controls create new reservation
  @smoke @regression
  Scenario: Verify Waiter can create anonymous reservation for Visitor
    When Waiter clicks "Create New Reservation"
    And waiter selects the date "13-05-2025"
    And Waiter chooses "Visitor"
    And Waiter chooses number of guests 2
    And Waiter selects from time "12:15"
    And Waiter choose a table "T001"
    And Waiter clicks on make reservationBtn
    Then Reservation is created and marked as "new reservation has been created successfully"
@smoke
  Scenario: Verify Waiter can create anonymous reservation for existinguser
    When Waiter clicks "Create New Reservation"
    And waiter selects the date "13-05-2025"
    And Waiter chooses "Customer"
    And waiter enter customer email "john.doe@example.com"
    And Waiter chooses number of guests 2
    And Waiter selects from time "12:15"
    And Waiter choose a table "T001"
    And Waiter clicks on make reservationBtn
    Then Reservation is created and marked as "new reservation has been created successfully"
