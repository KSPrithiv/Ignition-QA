@Counting @Regression
Feature: Testing of Counting Count functionality
  Scenario: Checking product history once Location is reconciled
    Given User signs in the application
    And Main page is loaded
    And Go to Lookup Product page
    And Waits for Product Lookup page to load
    And Validates Product Lookup Page base elements are loaded
    When User types product by index 2 on Counting Count page
    And Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    And Validates Product details are loaded on Lookup Product page
    Then User clicks History tab on Lookup Product page
    And Validates History tab details are loaded on Lookup Product page

  Scenario: Checking Combine Release and Assign Option on Counting Session screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 3 on Counting Sessions page
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    Then User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page
    And Validates Assignments columns are displayed on Counting Sessions page
    And User checks Assignment by index 0 on Counting Sessions page
    And Clicks Release button on Counting Sessions page

  Scenario: Checking Release Assignments on Counting Session screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And User clicks session dropdown on Counting Sessions page
    And Validates sessions are present in Session dropdown on Counting Sessions page
    And User clicks session page title on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 1 on Counting Sessions page
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    And User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page
    And Validates Assignments columns are displayed on Counting Sessions page
    And User checks Assignment by index 0 on Counting Sessions page
    And User checks Assignment by index 1 on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And User types future Release date in 3 days on Counting Sessions page
    And Selects user by index 0 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User checks All Assignments input on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User checks All Assignments input on Counting Sessions page
    And Validates Release button is disabled on Counting Sessions page
    And User checks Assignment by index 0 on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And Removes date and time on Counting Sessions page
    And Selects user by index 2 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And User types future Release date in 4 days on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And User types future Release date in 3 days on Counting Sessions page
    And Selects user by index 0 on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page