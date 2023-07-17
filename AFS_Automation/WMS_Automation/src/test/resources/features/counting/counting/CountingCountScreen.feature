@Counting @Regression
Feature: Testing of Counting Count functionality
  Scenario: Checking Navigate to Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Counting Count page
    And Validates Counting Count page is displayed
    Then Validates Counting Count page columns are displayed
    And Validates Add filter button on Counting Count page is displayed
    And Validates Items Count and Items Found on Counting Count page is displayed

  Scenario: Verify the Session belongs to the selected warehouse on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Count page
    And Validates Counting Count page is displayed
    When Validates Add filter button on Counting Count page is displayed
    And Validates Items Count and Items Found on Counting Count page is displayed
    Then Validates Product Search on Counting Count page is displayed
    And Validates Counting Count page columns are displayed
    And User selects warehouse by index 1 on Counting Count page
    And Validates Items Count and Items Found on Counting Count page is displayed

  Scenario: Verify the Sessions in the Session Dropdown on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Counting Count page
    And Validates Counting Count page is displayed
    Then User clicks Session dropdown on Counting Count page
    And Validates sessions are present on Counting Count page

  Scenario: Verify Add Filter on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Count page
    And Validates Counting Count page is displayed
    And Validates Items Count and Items Found on Counting Count page is displayed
    And Validates Items Count on Counting Count page are present
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
    And DockManagement Summary Page is validated
    And Go to Counting Count page
    And Waits for Counting Count page to load
    And Validates Counting Count page is displayed
    And Validates Counting Count page columns are displayed
    When User selects session by index 4 on Counting Count page
    And User clicks location by index 3 on Counting Count page
    Then Validates Location Label on Counting Count page is displayed
    And Validates Product, Factor and On Hand on Counting Count page are displayed
    And Validates Location Label on Counting Count page is displayed
    And Validates Count Quantity inputs are editable on Counting Count page
    And Validates Items Found, Add product, Product inputs, Cancel and Save buttons are displayed on Counting Count page
    And Validates Each and Bag are displayed on Counting Count page

  Scenario: Checking Count Pick Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Counting Count page
    And Validates Counting Count page is displayed
    Then Validates Add filter button on Counting Count page is displayed
    And Validates Product Search on Counting Count page is displayed
    And Validates Counting Count page columns are displayed

  Scenario: Checking Count Reserve Location on Counting Count screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Count page
    And Waits for Counting Count page to load
    And Validates Counting Count page is displayed
    And Validates Counting Count page columns are displayed
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
    And DockManagement Summary Page is validated
    And Go to Counting Count page
    And Waits for Counting Count page to load
    And Validates Counting Count page is displayed
    And Validates Counting Count page columns are displayed
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
    And DockManagement Summary Page is validated
    And Go to Counting Count page
    And Waits for Counting Count page to load
    And Validates Counting Count page is displayed
    And Validates Counting Count page columns are displayed
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
    And DockManagement Summary Page is validated
    And Go to Counting Count page
    And Validates Counting Count page is displayed
    And Validates Counting Count page columns are displayed
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

  Scenario: Checking product history once Location is reconciled
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
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
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User clicks session dropdown on Counting Sessions page
    And Validates sessions are present in Session dropdown on Counting Sessions page
    When User clicks session page title on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 3 on Counting Sessions page
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    Then User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And Validates Assignments columns are displayed on Counting Sessions page
    And User checks Assignment by index 0 on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And Validates "Assignments" Release popup is displayed on Counting Sessions page

  Scenario: Checking Release Assignments on Counting Session screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
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
    And Validates "Assignments" Release popup is displayed on Counting Sessions page
    And User types future Release date in 3 days on Counting Sessions page
    And User types future Release time "11:00" days on Counting Sessions page
    And Selects user by index 0 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User checks All Assignments input on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User checks All Assignments input on Counting Sessions page
    #issue
    And Validates Release button is disabled on Counting Sessions page
    And User checks Assignment by index 0 on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And Validates "Assignments" Release popup is displayed on Counting Sessions page
    And Removes date and time on Counting Sessions page
    And Selects user by index 2 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And Validates "Assignments" Release popup is displayed on Counting Sessions page
    And User types future Release date in 4 days on Counting Sessions page
    And User types future Release time "10:00" days on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And Validates "Assignments" Release popup is displayed on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Release button on Counting Sessions page
    And Validates "Assignments" Release popup is displayed on Counting Sessions page
    And User types future Release date in 3 days on Counting Sessions page
    And User types future Release time "11:00" days on Counting Sessions page
    And Selects user by index 0 on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page