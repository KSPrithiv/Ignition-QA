@WorkQueue @Regression
Feature: Testing of Work Queue Task functionality

  Scenario: Checking Navigate to Work Queue Task screen functionality
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Work Queue Task page
    And Waits for Work Queue Task page to load
    And Validates Work Queue Task page is displayed

  Scenario: Checking Navigate to Work Queue Task list functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Task page
    And Waits for Work Queue Task page to load
    And Validates Work Queue Task page is displayed
    And Validates Search Field in right top corner of the grid is displayed on Work Queue Task page
    And Hover mouse over Search on Work Queue Task page
    And Validates Searchable items are displayed as Tool tip on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    When Checks Task with index 1 on Work Queue Task page
    And Validates Items Selected are present on Work Queue Task page
    And Checks Task with index 1 on Work Queue Task page
    Then User clicks Add filter button on Work Queue Task page
    And Validates Add Filter options are present on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Product Checkbox on Work Queue Task page
    And Types Product by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Qty Checkbox on Work Queue Task page
    And Types Qty by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks From Checkbox on Work Queue Task page
    And Types From by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks To Checkbox on Work Queue Task page
    And Types To by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Type Checkbox on Work Queue Task page
    And Checks Movement Checkbox on Work Queue Task page
    And Clicks Task list title on Work Queue Task page
  #  And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Task Group Checkbox on Work Queue Task page
    And Checks Load Checkbox on Work Queue Task page
    And Clicks Task list title on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Status Checkbox on Work Queue Task page
    And Types Status by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Assignment Number Checkbox on Work Queue Task page
    And Types Assignment by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Priority Checkbox on Work Queue Task page
    And Types Priority by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Route Checkbox on Work Queue Task page
    And Types Route by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Stop Checkbox on Work Queue Task page
    And Types Stop by index 1 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Shipper Checkbox on Work Queue Task page
    And Types Shipper by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Velocity Checkbox on Work Queue Task page
    And Types Velocity by index 1 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Description Checkbox on Work Queue Task page
    And Types Description by index 0 on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page