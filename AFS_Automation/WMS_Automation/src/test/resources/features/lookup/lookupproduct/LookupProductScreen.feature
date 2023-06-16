@Lookup @Regression
Feature: Testing of Lookup Product functionality

  Scenario: Checking navigation functionality of Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded

  Scenario: Checking History screen of Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200018" on Lookup Product page
    And User clicks History tab on Lookup Product page
    And Validates Product details are loaded on Lookup Product page

  Scenario: Checking Setup screen of Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200018" on Lookup Product page
    And User clicks Setup tab on Lookup Product page
    And Validates Setup Product details are loaded on Lookup Product page

  Scenario: Checking Allocation screen of Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200018" on Lookup Product page
    And Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    And User clicks Allocation tab on Lookup Product page
    And Validates Allocation Product details are loaded on Lookup Product page

  Scenario: Checking Product Status Change functionality of Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200018" on Lookup Product page
    And Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    And Validates Product details are loaded on Lookup Product page
    And User clicks Status button on Lookup Product page
    And Validates 'Unit status' and 'Unit status Reason' on Lookup Product page
    And User selects Status "Hold Test" on Change Status popup on Lookup Product page
    And User clicks Save button on Lookup Product page
    And Validates Notification Message text "Please select status & reason" on Lookup Product page
    And User clicks Cancel button on Lookup Product page
    And User clicks Status button on Lookup Product page
    And User selects Unit status reason "Damaged" on Change Status popup on Lookup Product page
    And User clicks Save button on Lookup Product page
    And Validates Notification Message text "Please select status & reason" on Lookup Product page
    And User selects Status "Hold Test" on Change Status popup on Lookup Product page
    And User clicks Save button on Lookup Product page
    And Validates "Success" notification is displayed on Lookup Product page
    And User clicks Status button on Lookup Product page
    And User selects Status "Hold Test" on Change Status popup on Lookup Product page
    And User selects Unit status reason "Damaged" on Change Status popup on Lookup Product page
    And User clicks Cancel button on Lookup Product page

  Scenario: Checking Navigate to Location of Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200054" on Lookup Product page
    And Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And Validates Product details are loaded on Lookup Product page

  Scenario: Checking Show Pallet is present on Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200020" on Lookup Product page
    And Validates Lookup, Allocation, Setup and History Tabs are displayed on Lookup Product page
    And Validates Show Pallet CheckBox is displayed on Lookup Product page

  Scenario: Checking Grid Data on Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200002" on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Warehouse checkbox on Lookup Product page
    And Selects checkbox 1 on Lookup Product page
    And User clicks Product Lookup page title
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Owner checkbox on Lookup Product page
    And Selects checkbox 1 on Lookup Product page
    And User clicks Product Lookup page title
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Location checkbox on Lookup Product page
    And Types Location "101.056.80" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Location Type checkbox on Lookup Product page
    And Types Location Type "Case Pick" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Qty checkbox on Lookup Product page
    And Types Qty in range from "10" to "100" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks UOM checkbox on Lookup Product page
    And Types UOM "BG" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Task Type checkbox on Lookup Product page
    And Types Task Type "Putaway" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Destination checkbox on Lookup Product page
    And Types Destination "101.056.80" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Received checkbox on Lookup Product page
    And Types Received From date "01/01/2022" on Lookup Product page
    And Types Received Till date "11/01/2022" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Lot checkbox on Lookup Product page
    And Selects checkbox 1 on Lookup Product page
    And User clicks Product Lookup page title
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Expiry Date checkbox on Lookup Product page
    And Types From Exp Date "01/01/2022" on Lookup Product page
    And Types Till Exp Date "11/01/2022" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Status checkbox on Lookup Product page
    And Selects checkbox 0 on Lookup Product page
    And User clicks Product Lookup page title
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Weight checkbox on Lookup Product page
    And Types Qty in range from "10" to "100" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User checks Staged checkbox on Lookup Product page
    And Types Staged "No" on Lookup Product page
    And Clicks Apply Button on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User clicks Add Filter on Lookup Product page
    And User clicks Clear All on Lookup Product page

  Scenario: Checking Product Index functionality on Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200003" on Lookup Product page
    And Validates Grid items are present on Lookup Product page
    And User deletes product on Lookup Product page
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "APRIL24" on Lookup Product page
    And Validates Grid items are not present on Lookup Product page
    And User deletes product on Lookup Product page
    And Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User types product "200086" on Lookup Product page
    And Validates Product details are loaded on Lookup Product page
    And User deletes product on Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User deletes product on Lookup Product page
    And User types product "200087" on Lookup Product page
    And Validates Product details are loaded on Lookup Product page
    And Validates Grid items are present on Lookup Product page

  Scenario: Checking navigation to Product Lookup of Lookup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup Product page
    And Validates Product Lookup Page base elements are loaded
    And User clicks History tab on Lookup Product page
    And User types product "201004" on Lookup Product page
    And Validates Product details are loaded on Lookup Product page
    And Validates Grid items are present on Lookup Product page