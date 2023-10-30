@Lookup @Regression
Feature: Testing Lookup Location functionality
  @isofailed
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

#  Scenario: Checking Transfer functionality on Lookup Location screen
#    Given User signs in the application
#    And Main page is loaded
#    And DockManagement Summary Page is validated
#    And Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    When User types location "A02B2" on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And User clicks Column Header checkbox on Lookup Location page
#    Then User clicks Transfer button on Lookup Location page
#    And Validates popup text "A single item must be selected." on Location Lookup page
#    And User clicks OK button on Lookup Location page
#    And User clicks Column Header checkbox on Lookup Location page
#    And User checks Location Product 1 on Lookup Location page
#    And User clicks Transfer button on Lookup Location page
#    And Validates Transfer window title "Transfer product" on Location Lookup page
#    And Validates Transfer window details are displayed on Location Lookup page

#  Scenario: Checking Delete functionality on Lookup Location screen
#    Given User signs in the application
#    When Main page is loaded
#    And DockManagement Summary Page is validated
#    Then Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    And User types location "101.056.01" on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And User clicks Column Header checkbox on Lookup Location page
#    And User clicks Delete button on Lookup Location page
#    And Validates popup text "Remove highlighted items?" on Location Lookup page
#    And Validates Delete window title "Delete" on Location Lookup page
#    And Validates Yes and No buttons are displayed on Delete assignment popup on Location Lookup page
#    And User clicks Yes button on Lookup Location page
#    And Validates Delete Reason label and dropdown are displayed on Location Lookup page
#    And Validates Cancel and Ok buttons are displayed on Delete assignment popup on Location Lookup page
#    And User selects Delete Reason "Damaged" on Lookup Location page
#    And User clicks Cancel button on Lookup Location page

#  Scenario: Checking Edit functionality on Lookup Location screen
#    Given User signs in the application
#    When Main page is loaded
#    And DockManagement Summary Page is validated
#    Then Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    And User types location "101.056.01" on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And User clicks Column Header checkbox on Lookup Location page
#    And User clicks Edit button on Lookup Location page
#    And Validates popup text "A single item must be selected." on Location Lookup page
#    And User clicks OK button on Lookup Location page
#    And User clicks Column Header checkbox on Lookup Location page
#    And User checks Location Product 1 on Lookup Location page
#    And User clicks Edit button on Lookup Location page
#    And Validates Edit inventory elements are displayed on Location Lookup page
#    And Validates Product index field is greyed-out on Location Lookup page
#    And User types Qty "100" on Lookup Location page
#    And Validates Inventory Reason Label and Inventory Reason are displayed on Location Lookup page
#    And User types Qty "0" on Lookup Location page
#    And Validates Delete Reason Label and Delete Reason are displayed on Location Lookup page
#    And User selects Delete Reason "Quantity Adjustment" on Lookup Location page
#    And User types Date Code "10102010" on Lookup Location page
#    And User selects Date Code Reason "Office Expense" on Lookup Location page
#    And User clicks Cancel button on Lookup Location page

#  Scenario: Checking Add Location button functionality on Lookup Location screen
#    Given User signs in the application
#    When Main page is loaded
#    And DockManagement Summary Page is validated
#    Then Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    And User types location "101.056.01" on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And Clicks Add Location button on Lookup Location page
#    And Validates LPN, Product and Type are displayed on Location Lookup page
#    And Validates Cancel and Save buttons are displayed on Add inventory on Location Lookup page
#    And Validates LPN field should be empty on Location Lookup page
#    And User types LPN "09" on Lookup Location page
#    And User clicks Save button on Lookup Location page
#    And Validates dialog content text "Invalid pallet number" on Location Lookup page
#    And User clicks OK button on Lookup Location page
#    And User types LPN "0909090909" on Lookup Location page
#    And User clicks Save button on Lookup Location page
#    And Validates dialog content text "Pallet Number should be less than" on Location Lookup page
#    And User clicks OK button on Lookup Location page
#    And User clicks Cancel button on Lookup Location page
#    And Clicks Add Location button on Lookup Location page
#    And User types Product "111" on Lookup Location page
#    And User clicks Save button on Lookup Location page
#    And User clicks OK button on Lookup Location page
#    And Validates LPN field should be not empty on Location Lookup page
#    And User clicks Pallet Type on Add Inventory Lookup Location page
#    And Validates options from dropdown are present on Location Lookup page
#    And User clears Product on Lookup Location page
#    And User types Product "11" on Lookup Location page
#    And Validates product details for location on Location Lookup page
#    And User types Future Date in 3 days on Lookup Location page
#    And User clears Product Qty on Lookup Location page
#    And User clicks Save button on Lookup Location page
#    And Validates dialog content text "Please enter a quantity." on Location Lookup page
#    And User clicks OK button on Lookup Location page
#    And User selects Status "Hold Test" on Lookup Location page
#    And User clicks Cancel button on Lookup Location page

#  Scenario: Checking Status button functionality on Lookup Location screen
#    Given User signs in the application
#    When Main page is loaded
#    And DockManagement Summary Page is validated
#    Then Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    And User types location "101.056.01" on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And User checks Location Product 1 on Lookup Location page
#    And User clicks Status button on Lookup Location page
#    And Validates 'Unit status' and 'Unit status Reason' on Location Lookup page
#    And User selects Status "Hold Test" on Change Status popup on Lookup Location page
#    And User clicks Save button on Lookup Location page
#    And Validates Notification Message text "Please select status & reason" on Lookup Location page
#    And User clicks Cancel button on Lookup Location page
#    And User clicks Status button on Lookup Location page
#    And User selects Unit status reason "Damaged" on Change Status popup on Lookup Location page
#    And User clicks Save button on Lookup Location page
#    And Validates Notification Message text "Please select status & reason" on Lookup Location page
#    And User selects Status "Hold Test" on Change Status popup on Lookup Location page
#    And User clicks Save button on Lookup Location page
#    And Validates "Success" notification is displayed on Lookup Location page
#    And User checks Location Product 2 on Lookup Location page
#    And User clicks Status button on Lookup Location page
#    And User selects Status "Hold Test" on Change Status popup on Lookup Location page
#    And User selects Unit status reason "Damaged" on Change Status popup on Lookup Location page
#    And User clicks Save button on Lookup Location page
#    And Validates "Success" notification is displayed on Lookup Location page
#    And User checks Location Product 2 on Lookup Location page
#    And User clicks Status button on Lookup Location page
#    And Validates 'Unit status' and 'Unit status Reason' on Location Lookup page
#    And User clicks Cancel button on Lookup Location page
#    And User checks Location Product 1 on Lookup Location page
#    And User clicks Status button on Lookup Location page
#    And Validates popup text "A single item must be selected." on Location Lookup page
#    And Validates Delete window title "Warning message" on Location Lookup page
#
#  Scenario: Checking Location index and details functionality on Lookup Location screen
#    Given User signs in the application
#    When Main page is loaded
#    And DockManagement Summary Page is validated
#    Then Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    And User enters location "101.056" on Lookup Location page
#    And Validates options from dropdown are present on Location Lookup page
#    And User clears location on Lookup Location page
#    And User types location "101.056.01" on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And User clicks Location Product 1 on Lookup Location page
#    And Validates Product Lookup Page base elements are loaded
#    And Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    And User clears location on Lookup Location page
#    And User types location "303.026.70" on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And Validates Grid items are not present on Lookup Location page
#    And Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    And User clears location on Lookup Location page
#    And User types location "101.056.01" on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And Go to Lookup Location page
#    And Waits for Location Lookup page to load
#    And User clears location on Lookup Location page
#    And User clicks location search button on Lookup Location page
#    And User selects location by index 2 on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are loaded
#    And User cleans Location Input on Lookup Location page
#    And Validates Inventory details of location on Location Lookup page are not displayed

  @isofailed
  Scenario: Checking Navigate to Lookup Location on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Lookup Location page
    And Waits for Location Lookup page to load
    Then Validates Location Search Field is present on Lookup Location page

  @isofailed
  Scenario: Checking Navigate to Production mode on Lookup Location screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Location page
    And Waits for Location Lookup page to load
    When User enters location by index 2 on Lookup Location page
    Then Clicks Production on button on Lookup Location page
    And Validates Production label by index 2 on Lookup Location page

  @isofailed
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