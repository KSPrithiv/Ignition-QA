@Counting @Regression
Feature: Testing of Counting Count functionality
  Scenario: Checking Assignment Details on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    When User clicks session dropdown on Counting Sessions page
    And User selects session with index 0 on Counting Sessions page
    And Validates Session details on Counting Sessions page
    Then User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page

  Scenario: Checking Search Control and Add Filter and Sorting for Assignments on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    When User clicks session dropdown on Counting Sessions page
    And User selects session with index 2 on Counting Sessions page
    And Validates Session details on Counting Sessions page
    Then User clicks Assignments tab on Counting Sessions page
    And User clicks Clear Filter on Counting Sessions page
    And User clicks Add Filter on Counting Sessions page
    And Validates Assignment filters are displayed on Counting Sessions page

  Scenario: Checking Add Products from Product pab on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And Validates Counting Sessions page is displayed
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 1 on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types product "000014" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Deletes cookies on application
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types product "0000144" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "50" number of products on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects product type by index 2 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects movement class by index 1 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types supplier by index 2 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types prod alias type by index 4 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "Hidden" inventory status on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects product type by index 1 on Counting Sessions page
    And Selects movement class by index 2 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects product type by index 1 on Counting Sessions page
    And Selects movement class by index 2 on Counting Sessions page
    And Types supplier by index 3 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects product type by index 1 on Counting Sessions page
    And Selects movement class by index 2 on Counting Sessions page
    And Types supplier by index 3 on Counting Sessions page
    And Selects owner dropdown by index 2 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects product type by index 1 on Counting Sessions page
    And Selects movement class by index 2 on Counting Sessions page
    And Types supplier by index 3 on Counting Sessions page
    And Selects owner dropdown by index 2 on Counting Sessions page
    And Types inventory status by index 4 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects product type by index 1 on Counting Sessions page
    And Selects movement class by index 2 on Counting Sessions page
    And Types supplier by index 3 on Counting Sessions page
    And Selects owner dropdown by index 2 on Counting Sessions page
    And Types inventory status by index 5 on Counting Sessions page
    And Types prod alias type by index 1 on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects product type by index 1 on Counting Sessions page
    And Selects movement class by index 2 on Counting Sessions page
    And Types supplier by index 3 on Counting Sessions page
    And Selects owner dropdown by index 2 on Counting Sessions page
    And Types inventory status by index 5 on Counting Sessions page
    And Types prod alias type by index 1 on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page