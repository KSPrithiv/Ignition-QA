@Lookup @Regression
Feature: Testing of Lookup Product functionality

  Scenario: Checking navigation functionality of Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Lookup Product page
    Then Validates Product Lookup Page base elements are loaded

#  Scenario: Checking History screen of Lookup Product screen
#    Given User signs in the application
#    When Main page is loaded
#    And DockManagement Summary Page is validated
#    Then Go to Lookup Product page
#    And Validates Product Lookup Page base elements are loaded
#    And User types product "200018" on Lookup Product page
#    And User clicks History tab on Lookup Product page
#    And Validates Product details are loaded on Lookup Product page

  Scenario: Checking Setup screen of Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User clicks Add Product on Lookup Product page
    When User clicks product by index 3 on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    Then User clicks Setup tab on Lookup Product page
    And Validates Setup Product details are loaded on Lookup Product page

  Scenario: Checking Allocation screen of Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User clicks Add Product on Lookup Product page
    When User clicks product by index 3 on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    Then User clicks Allocation tab on Lookup Product page
    And Validates Allocation Product details are loaded on Lookup Product page

  Scenario: Checking Product Status Change functionality of Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User clicks Add Product on Lookup Product page
    And User clicks product by index 3 on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    When User clicks Status button on Lookup Product page
    And Validates 'Unit status' and 'Unit status Reason' on Lookup Product page
    And User selects Status by index 0 on Change Status popup on Lookup Product page
    And User clicks Save button on Lookup Product page
    Then Validates Notification Message text "Please select status & reason" on Lookup Product page
    And User clicks Cancel button on Lookup Product page
    And User clicks Status button on Lookup Product page
    And User selects Unit status reason by index 1 on Change Status popup on Lookup Product page
    And User clicks Save button on Lookup Product page
    And Validates Notification Message text "Please select status & reason" on Lookup Product page
    And User selects Status by index 1 on Change Status popup on Lookup Product page
    And User clicks Save button on Lookup Product page
    And Validates "Success" notification is displayed on Lookup Product page
    And User clicks Status button on Lookup Product page
    And User selects Status by index 1 on Change Status popup on Lookup Product page
    And User selects Unit status reason by index 1 on Change Status popup on Lookup Product page
    And User clicks Cancel button on Lookup Product page

  Scenario: Checking Navigate to Location of Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    When User clicks Add Product on Lookup Product page
    And User clicks product by index 3 on Lookup Product page
    Then Validates Grid items are present on Lookup Product page
    And Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And Validates Product details are loaded on Lookup Product page

  Scenario: Checking Show Pallet is present on Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    When User clicks Add Product on Lookup Product page
    And User clicks product by index 3 on Lookup Product page
    Then Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    And Validates Show Pallet CheckBox is displayed on Lookup Product page

  Scenario: Checking Grid Data on Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User clicks Add Product on Lookup Product page
    When User clicks product by index 7 on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Warehouse checkbox on Lookup Product page
    Then Selects checkbox 1 on Lookup Product page
    And User clicks Product Lookup page title
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Location checkbox on Lookup Product page
    And Types Location "A02C2" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page

  Scenario: Checking Product Index functionality on Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User clicks Add Product on Lookup Product page
    And User clicks product by index 3 on Lookup Product page
    And User deletes product on Lookup Product page
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User clicks Add Product on Lookup Product page
    And User clicks product by index 0 on Lookup Product page

  Scenario: Checking navigation to Product Lookup of Lookup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    When User clicks Add Product on Lookup Product page
    And User clicks product by index 3 on Lookup Product page
    Then Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page