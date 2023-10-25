@Appointments @Regression
Feature: Testing of Appointment Scheduler functionality
  Scenario: Checking Appointment Scheduler Navigation functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Appointment scheduler page
    Then Appointment Scheduler page is displayed

  Scenario: Checking Appointment Scheduler Creation With Valid Order functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    When User searches for valid order "R" for appointment on Appointment Scheduler page
    And Validates Order Data on Appointment Scheduler page
    And User selects order by row number 0 on Appointment Scheduler page
    Then Click Next on Appointment Scheduler page
    And Validates Delivery Type and Email on Appointment Scheduler Delivery page are displayed
    And Click Next on Appointment Scheduler page
    And Validates Submit button is active on Appointment Scheduler page
    And Validates Scheduler date and Scheduler time on Appointment Scheduler page

  Scenario: Checking Cancel Appointment Scheduler Creation With Valid Order
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    When User types order number "1" on Appointment Scheduler page
    Then Validates Invalid Order Warning on Appointment Scheduler page
    And Validates Next Button is not active on Appointment Scheduler page
    And Validates Cancel Button is not active on Appointment Scheduler page

  Scenario: Checking Cancel Appointment Scheduler Creation With Valid Order
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    When User searches for valid order "R" for appointment on Appointment Scheduler page
    And Validates Order Data on Appointment Scheduler page
    And User selects order by row number 0 on Appointment Scheduler page
    Then Click Next on Appointment Scheduler page
    And Validates Delivery Type and Email on Appointment Scheduler Delivery page are displayed
    And Types email "testuser@gmail.com" on Appointment Scheduler page
    And User selects delivery "DRY" on Appointment Scheduler page
    And Click Next on Appointment Scheduler page
    And User types Future Date in 10 days on Appointment Scheduler page
    And Click Cancel button on Appointment Scheduler page