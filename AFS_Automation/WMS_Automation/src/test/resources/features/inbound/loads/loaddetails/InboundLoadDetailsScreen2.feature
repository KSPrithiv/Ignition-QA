@Inbound @Regression
Feature: Testing of Inbound Load Details screen functionality
  Scenario: Checking Receive option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Selects Load Option "Receive" for Load
    And Receiving page loads
    And Receiving page contains all web elements

  Scenario: Checking Data option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Clicks data option on Inbound Load Summary page
    And Types temperature by index 0 on Inbound Load Summary page
    And Types seal number by index 0 on Inbound Load Summary page
    And Clicks Add Product Cancel Button on Inbound Load Summary page

  Scenario: Checking Edit option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 2 on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Selects Load Option "Edit" for Load
    And Validates Edit load popup on Inbound Load Summary page
    And Types "testdriver" driver for Load
    And Clicks Save button on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Select Load with index 0 on Inbound Load Summary page
    And Selects Load Option "Edit" for Load
    And Validates Edit load popup on Inbound Load Summary page
    And Clicks Cancel button on Inbound Load Summary page

  Scenario: Checking Door option for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks door on Assign doors popup on Inbound Load Summary page
    And Clicks door "DR01" on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Validates "Success" notification is displayed on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks door on Assign doors popup on Inbound Load Summary page
    And Clicks door "DOOR" on Inbound Load Summary page
    And Clicks Save button on Inbound Load Summary page
    And Clicks door option on Inbound Load Summary page
    And Validates popup Assign doors title for Inbound Load Summary
    And Clicks Cancel button on Inbound Load Summary page

  Scenario: Checking Back button for Load on Load details screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present
    When Types start date by index 4 on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Clicks Route Back button on Inbound Load Summary page
    And Inbound Load Summary page appears
    And Inbound Load Summary page main elements are present