@Counting @Regression
Feature: Testing of Counting Count functionality
  Scenario: Checking Navigate to Counting Count screen
    Given User signs in the application
    And Main page is loaded
    When Go to Counting Count page
    And Waits for Counting Count page to load
    And Validates Counting Count page is displayed
    Then Validates Counting Count page columns are displayed
    And Validates Add filter button on Counting Count page is displayed
    And Validates Items Count and Items Found on Counting Count page is displayed

  Scenario: Verify the Session belongs to the selected warehouse on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When Validates Add filter button on Counting Count page is displayed
    And Validates Items Count and Items Found on Counting Count page is displayed
    Then Validates Product Search on Counting Count page is displayed
    And Validates Counting Count page columns are displayed
    And User selects warehouse by index 1 on Counting Count page
    And Validates Items Count and Items Found on Counting Count page is displayed

  Scenario: Verify the Sessions in the Session Dropdown on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    When Go to Counting Count page
    And Waits for Counting Count page to load
    Then User clicks Session dropdown on Counting Count page
    And Validates sessions are present on Counting Count page

  Scenario: Verify Add Filter on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User clicks Add Filter on Counting Count page
    And User clicks Location filter on Counting Count page
    And User types Location filter by index 0 on Counting Count page
    And User clicks Apply button on Counting Count page
    And Validates Items Count on Counting Count page are present
    And User clicks Add Filter on Counting Count page
    And User clicks Clear All button on Counting Count page
    And User clicks Add Filter on Counting Count page
    And User clicks UPC Filter on Counting Count page
    Then User types UPC filter by index 0 on Counting Count page
    And User clicks Apply button on Counting Count page
    And Validates Items Count on Counting Count page are present
    And User clicks Add Filter on Counting Count page
    And User clicks Clear All button on Counting Count page
    And User clicks Add Filter on Counting Count page
    And User clicks UOM filter on Counting Count page
    And User types UOM filter by index 1 on Counting Count page
    And User clicks Apply button on Counting Count page
    And Validates Items Count on Counting Count page are present
    And User clicks Add Filter on Counting Count page
    And User clicks Clear All button on Counting Count page
    And User clicks Add Filter on Counting Count page
    And User clicks Product filter on Counting Count page
    And User types Product filter by index 0 on Counting Count page
    And User clicks Apply button on Counting Count page
    And Validates Items Count on Counting Count page are present

  @f1
  Scenario: Checking Count the Locations on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page


  Scenario: Checking Count Pick Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    When Go to Counting Count page
    And Waits for Counting Count page to load
    Then Validates Add filter button on Counting Count page is displayed
    And Validates Product Search on Counting Count page is displayed
    And Validates Counting Count page columns are displayed

  @f1
  Scenario: Checking Count Reserve Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page

  @f1
  Scenario: Checking Count Empty Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page

  @f1
  Scenario: Checking Add Product to the Empty or non Empty Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page


  @f1
  Scenario: Checking saving counted location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page

