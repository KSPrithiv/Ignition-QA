@Counting @Regression
Feature: Testing of Counting Dashboard functionality

  Scenario: Checking Navigate to Counting Dashboard screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Counting Dashboard page
    And Waits for Counting Dashboard page to load
    And Validates Counting Dashboard page is displayed
    Then Validates Location and Product tabs are displayed on Counting Dashboard page
    And Validates Locations counted dashboard and Locations with discrepancies are displayed on Counting Dashboard page

  Scenario: Checking Locations counted Section should be removed on Counting Dashboard screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Dashboard page
    And Waits for Counting Dashboard page to load
    And Validates Counting Dashboard page is displayed
    And Validates Location and Product tabs are displayed on Counting Dashboard page
    And Validates Locations counted dashboard and Locations with discrepancies are displayed on Counting Dashboard page
    When User click Product tab on Counting Dashboard page
    Then Validates Products counted dashboard and Products with discrepancies are displayed on Counting Dashboard page