@Dashboard @Regression
Feature: Testing of Counting Dashboard functionality

  Scenario: Checking Navigate to Counting Dashboard screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Dashboard page
    And Waits for Counting Dashboard page to load
    And Validates Counting Dashboard page is displayed
    And Validates Location and Product tabs are displayed on Counting Dashboard page
    And Validates Locations counted dashboard and Locations with discrepancies are displayed on Counting Dashboard page

  Scenario: Checking Locations counted Section should be removed on Counting Dashboard screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Dashboard page
    And Waits for Counting Dashboard page to load
    And Validates Counting Dashboard page is displayed
    And Validates Location and Product tabs are displayed on Counting Dashboard page
    And Validates Locations counted dashboard and Locations with discrepancies are displayed on Counting Dashboard page
    And User click Product tab on Counting Dashboard page
    And Validates Products counted dashboard and Products with discrepancies are displayed on Counting Dashboard page