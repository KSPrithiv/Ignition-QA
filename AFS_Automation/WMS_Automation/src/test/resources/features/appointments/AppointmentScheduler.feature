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
    And User searches for valid order "R" for appointment on Appointment Scheduler page
    And Validates Order Data on Appointment Scheduler page
    And User selects order by row number 0 on Appointment Scheduler page
    And Click Next on Appointment Scheduler page
    And Validates Delivery Type and Email on Appointment Scheduler Delivery page are displayed
    And Click Next on Appointment Scheduler page
    And Validates Submit button is active on Appointment Scheduler page
  #  And Click Submit button on Appointment Scheduler page
  #  And Appointment Scheduler page is displayed

  Scenario: Checking Cancel Appointment Scheduler Creation With Valid Order
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    And User searches for valid order "R" for appointment on Appointment Scheduler page
    And Waits for Appointment Scheduler Linked Orders PopUp Page to load
    And Validates Linked Orders popup is displayed on Appointment Scheduler Linked Orders PopUp Page
    And Validates Linked Orders popup content is displayed on Appointment Scheduler Linked Orders PopUp Page
    And Validates Linked Orders popup Ok button on Appointment Scheduler Linked Orders PopUp Page
    And Validates Linked Orders popup Cancel button on Appointment Scheduler Linked Orders PopUp Page
    And Click Ok button on Linked Orders popup on Appointment Scheduler page
    And Validates Order Data on Appointment Scheduler page
    And Validates Linked Order with index 0 on Appointment Scheduler page
    And Validates Linked Order with index 1 on Appointment Scheduler page
    And Validates table rows number 2 on Appointment Scheduler page
    And User deletes order by row number 1 on Appointment Scheduler page
    And Validates Order Data on Appointment Scheduler page
    And Validates table rows number 1 on Appointment Scheduler page
    And Click Next on Appointment Scheduler page
    And Validates Delivery Type and Email on Appointment Scheduler Delivery page are displayed
    And Click Next on Appointment Scheduler page
    And Validates Select Delivery Type Warning on Appointment Scheduler page
    And Selects DOOR Delivery Type on Appointment Scheduler page
    And Types email "testemail@gmail.com" on Appointment Scheduler page
    And Click Next on Appointment Scheduler page
    And Click Cancel button on Appointment Scheduler page
    And Click Next on Appointment Scheduler page
    And Validates Submit button is active on Appointment Scheduler page
    And Click Cancel button on Appointment Scheduler page

  Scenario: Checking Cancel Appointment Scheduler Creation With Invalid Order
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Appointment scheduler page
    And Waiting Appointment Scheduler Page To Load
    And Appointment Scheduler page is displayed
    And User types order number "gUnhb" on Appointment Scheduler page
    And Validates invalid order warning