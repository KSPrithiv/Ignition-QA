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

  Scenario: Checking Count the Locations on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page
    Then Validates Location Label on Counting Count page is displayed
    And Validates Product, Factor and On Hand on Counting Count page are displayed
    And Validates Location Label on Counting Count page is displayed
    And Validates Count Quantity inputs are editable on Counting Count page
    And Validates Items Found, Add product, Product inputs, Cancel and Save buttons are displayed on Counting Count page
    And Validates Each and Cases are displayed on Counting Count page

  Scenario: Checking Count Pick Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    When Go to Counting Count page
    And Waits for Counting Count page to load
    Then Validates Add filter button on Counting Count page is displayed
    And Validates Product Search on Counting Count page is displayed
    And Validates Counting Count page columns are displayed

  Scenario: Checking Count Reserve Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page
    And Validates Location Label on Counting Count page is displayed
    Then Validates Product, Factor and On Hand on Counting Count page are displayed
    And Validates Location Label on Counting Count page is displayed
    And Validates Count Quantity inputs are editable on Counting Count page
    And Validates Each and Cases are displayed on Counting Count page

  Scenario: Checking Count Empty Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page
    And Validates Count Quantity inputs are editable on Counting Count page
    Then Validates Items Found, Add product, Product inputs, Cancel and Save buttons are displayed on Counting Count page
    And User types "1" quantity in 0 input on Counting Count page
    And Validates Count Quantity value "1" in 0 input field on Counting Count page
    And User types "2" quantity in 1 input on Counting Count page
    And Validates Count Quantity value "2" in 1 input field on Counting Count page
    And Validates Items Found, Add product, Product inputs, Cancel and Save buttons are displayed on Counting Count page

  Scenario: Checking Add Product to the Empty or non Empty Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page
    And User clicks Add Product on Counting Count page
    And Validates LPN, LPN Type and Product Code are displayed on Counting Count page
    Then User types product by index 2 on Counting Count page
    And Validates Product details are displayed on Counting Count page
    And User selects owner by index 4 on Counting Count page
    And User selects supplier by index 2 on Counting Count page
    And User types qty "2" on Counting Count page
    And User selects UOM by index 3 on Counting Count page
    And User selects status by index 0 on Counting Count page
    And Clicks Cancel button on Counting Count page
    And Validates Items Found, Add product, Product inputs, Cancel and Save buttons are displayed on Counting Count page

  Scenario: Checking saving counted location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Count page
    And Waits for Counting Count page to load
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page
    And User clicks Add Product on Counting Count page
    And Validates LPN, LPN Type and Product Code are displayed on Counting Count page
    Then User types product by index 2 on Counting Count page
    And Validates Product details are displayed on Counting Count page
    And User selects owner by index 4 on Counting Count page
    And User selects supplier by index 2 on Counting Count page
    And User types qty "2" on Counting Count page
    And User selects UOM by index 3 on Counting Count page
    And User selects status by index 0 on Counting Count page
    And Validates save button enabled on Counting Count page