@Lookup @Regression
Feature: Testing Lookup Location functionality
  Scenario: Checking navigation functionality on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User types location by index 0 on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    Then User clicks Location Product 1 on Lookup Location page
    And Validates Product Lookup Page base elements are loaded

  Scenario: Checking Navigate to Lookup Location on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Lookup Location page
    And Waits for Location Lookup page to load
    Then Validates Location Search Field is present on Lookup Location page

  Scenario: Checking Navigate to Production mode on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User enters location by index 2 on Lookup Location page
    Then Clicks Production on button on Lookup Location page
    And Validates Production label by index 2 on Lookup Location page

  Scenario: Checking Adding inventory to Production mode on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User enters location by index 2 on Lookup Location page
    And Clicks Production on button on Lookup Location page
    Then Clicks Add Location button on Lookup Location page
    And Validates LPN, Product and Type are displayed on Location Lookup page
    And Validates Cancel and Save buttons are displayed on Add inventory on Location Lookup page
    And User types Product by index 0 on Lookup Location page
    And User types Receipt date by index 5 on Lookup Location page
    And Validates Production Reason on Location Lookup page
    And User clicks Production Reason dropdown on Lookup Location page
    And Validates Production Reasons exist on Location Lookup page
    And User types Qty "1" on Lookup Location page
    And Selects supplier by index 1 on Lookup Location page
    And Selects Production Reason "Production" on Lookup Location page
    And User types Expiration date by index 5 on Lookup Location page
    And User clicks Save button on Lookup Location page