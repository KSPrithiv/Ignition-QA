@Lookup @Regression
Feature: Testing Lookup Location functionality
  Scenario: Checking Edit inventory in Production mode on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User enters location by index 2 on Lookup Location page
    And Clicks Production on button on Lookup Location page
    And User clicks Show detail checkbox on Lookup Location page
    And User checks Location Product 1 on Lookup Location page
    And User clicks Edit button on Lookup Location page
    And Validates Edit inventory elements are displayed on Location Lookup page
    Then User types Receipt date by index 5 on Lookup Location page
    And User clicks Save button on Lookup Location page

  Scenario: Checking Delete inventory in Production mode on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User enters location by index 2 on Lookup Location page
    And Clicks Production on button on Lookup Location page
    And User clicks Show detail checkbox on Lookup Location page
    Then User checks Location Product 1 on Lookup Location page
    And User clicks Delete button on Lookup Location page
    And Validates popup text "Remove highlighted items?" on Location Lookup page
    And Validates Delete window title "Delete" on Location Lookup page
    And Validates Yes and No buttons are displayed on Delete assignment popup on Location Lookup page
    And User clicks No button on Lookup Location page
    And User clicks Delete button on Lookup Location page
    And Validates popup text "Remove highlighted items?" on Location Lookup page
    And Validates Delete window title "Delete" on Location Lookup page
    And User clicks Yes button on Lookup Location page
    And Validates Delete Reason label and dropdown are displayed on Location Lookup page
    And User clicks Cancel button on Lookup Location page
    And Clicks Production on button on Lookup Location page

  Scenario: Checking Non Product Reasons on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User enters location by index 2 on Lookup Location page
    And Clicks Production on button on Lookup Location page
    And User clicks Show detail checkbox on Lookup Location page
    And User checks Location Product 1 on Lookup Location page
    And Clicks Add Location button on Lookup Location page
    And Validates LPN, Product and Type are displayed on Location Lookup page
    Then User types Product by index 3 on Lookup Location page
    And Validates Production Reason on Location Lookup page
    And User clicks Production Reason dropdown on Lookup Location page
    And Validates Production Reasons exist on Location Lookup page
    And User clicks Cancel button on Lookup Location page
    And User checks Location Product 1 on Lookup Location page
    And User clicks Edit button on Lookup Location page
    And Validates Edit inventory elements are displayed on Location Lookup page
    And User types Receipt date by index 5 on Lookup Location page
    And User clicks Cancel button on Lookup Location page
    And User checks Location Product 1 on Lookup Location page
    And User clicks Delete button on Lookup Location page
    And Validates popup text "Remove highlighted items?" on Location Lookup page
    And Validates Delete window title "Delete" on Location Lookup page
    And User clicks Yes button on Lookup Location page
    And Validates Delete Reason label and dropdown are displayed on Location Lookup page

  Scenario: Checking not able to create inventory for product configured on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Setup Product page
    And Waits for Setup Product page to load
    When User selects product by index 1 on Setup Product page
    And User clicks Edit on Setup Product page
    And User clicks Shipping tab on Setup Product page
    And Checks individual catch weight checkbox on Setup Product page
    And Clicks Save on Setup Product page
    And Clicks Save on popup on Setup Product page
    Then Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User enters location by index 2 on Lookup Location page
    And Clicks Add Location button on Lookup Location page
    And Validates LPN, Product and Type are displayed on Location Lookup page
    And Validates Cancel and Save buttons are displayed on Add inventory on Location Lookup page
    And User selects product by index 0 on Setup Product page
    And User types Receipt date by index 5 on Lookup Location page
    And User types Qty "1" on Lookup Location page
    And Selects supplier by index 0 on Lookup Location page
    And User types Expiration date by index 5 on Lookup Location page
    And Selects Inventory Reason by index 1 on Lookup Location page
    And User clicks Save button on Lookup Location page
    And User clicks Show detail checkbox on Lookup Location page
    And User checks Product by index 0 on Lookup Location page
    And User clicks Edit button on Lookup Location page
    And Validates Edit inventory elements are displayed on Location Lookup page
    And User clicks Cancel button on Lookup Product page
    And User checks Product by index 0 on Lookup Location page
    And User clicks Delete button on Lookup Location page
    And Validates popup text "Remove highlighted items?" on Location Lookup page
    And Validates Delete window title "Delete" on Location Lookup page
    And Validates Yes and No buttons are displayed on Delete assignment popup on Location Lookup page
    And User clicks Yes button on Lookup Location page
    And Validates Delete Reason label and dropdown are displayed on Location Lookup page
    And User clicks Ok button on Lookup Location page

  Scenario: Checking verification of supplier on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User enters location by index 2 on Lookup Location page
    And Clicks Add Location button on Lookup Location page
    And Validates LPN, Product and Type are displayed on Location Lookup page
    And Validates Cancel and Save buttons are displayed on Add inventory on Location Lookup page
    Then User types Product by index 2 on Lookup Location page
    And Clicks supplier on Lookup Location page
    And Validates Suppliers number is more than 1 on Location Lookup page
    And User clicks Cancel button on Lookup Location page
    And Clicks Add Location button on Lookup Location page
    And Validates LPN, Product and Type are displayed on Location Lookup page
    And Validates Cancel and Save buttons are displayed on Add inventory on Location Lookup page
    And User types Product by index 2 on Lookup Location page
    And Clicks supplier on Lookup Location page
    And Validates Suppliers number is more than 1 on Location Lookup page

  Scenario: Checking update existing LPN on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User enters location by index 2 on Lookup Location page
    And User clicks Show detail checkbox on Lookup Location page
    And User checks Location Product 0 on Lookup Location page
    When User clicks Edit button on Lookup Location page
    And Validates Edit inventory elements are displayed on Location Lookup page
    And User clears edit LPN on Lookup Location page
    And User types Expiration date by index 5 on Lookup Location page
    Then User clicks Save button on Lookup Location page
    And User clicks Cancel button on Lookup Location page
    And User checks Location Product 0 on Lookup Location page
    And User clicks Edit button on Lookup Location page
    And Validates Edit inventory elements are displayed on Location Lookup page
    And User edits LPN "090  21051222222" on Lookup Location page
    And User types Receipt date by index 5 on Lookup Location page
    And User clicks Save button on Lookup Location page
    And User clicks Cancel button on Lookup Location page
    And User checks Location Product 0 on Lookup Location page
    And User clicks Edit button on Lookup Location page
    And Validates Edit inventory elements are displayed on Location Lookup page
    And User edits LPN "090 @21051222222" on Lookup Location page
    And User types Expiration date by index 5 on Lookup Location page
    And User clicks Save button on Lookup Location page

  Scenario: Checking Add Inventory button functionality on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    And User enters location by index 2 on Lookup Location page
    And Validates Inventory details of location on Location Lookup page are loaded
    When Clicks Add Location button on Lookup Location page
    And Validates LPN, Product and Type are displayed on Location Lookup page
    And Validates Cancel and Save buttons are displayed on Add inventory on Location Lookup page
    And Validates LPN field should be empty on Location Lookup page
    Then User types LPN "09" on Lookup Location page
    And User types Product by index 2 on Lookup Location page
    And User clicks Save button on Lookup Location page
    And Validates dialog content text "Invalid pallet number" on Location Lookup page
    And User clicks Ok button on Lookup Location page
    And User types LPN "0909090909" on Lookup Location page
    And User clicks Save button on Lookup Location page
    And Validates dialog content text "Pallet Number should be less than" on Location Lookup page
    And User clicks Ok button on Lookup Location page
    And User clicks Cancel button on Lookup Location page
    And Clicks Add Location button on Lookup Location page
    And Validates LPN, Product and Type are displayed on Location Lookup page
    And User types LPN "" on Lookup Location page
    And User types Product by index 2 on Lookup Location page
    And User clicks Pallet Type on Add Inventory Lookup Location page
    And Validates Types number is more than 0 on Location Lookup page
    And Selects Product Status by index 0 on Lookup Location page
    And User types Qty "1" on Lookup Location page
    And Selects supplier by index 1 on Lookup Location page
    And Selects Production Reason by index 2 on Lookup Location page
    And User types Expiration date by index 5 on Lookup Location page
    And User types Receipt date by index 5 on Lookup Location page
    And User clicks Save button on Lookup Location page