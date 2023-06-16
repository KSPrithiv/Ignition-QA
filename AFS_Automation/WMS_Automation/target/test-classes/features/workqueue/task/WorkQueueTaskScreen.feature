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
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Work Queue Task page
    And Waits for Work Queue Task page to load
    And Validates Work Queue Task page is displayed
    And Validates Search Field in right top corner of the grid is displayed on Work Queue Task page
    And Hover mouse over Search on Work Queue Task page
    And Validates Searchable items are displayed as Tool tip on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And Checks Task with index 1 on Work Queue Task page
    And Validates Items Selected are present on Work Queue Task page
    And Checks Task with index 1 on Work Queue Task page
    And Validates Items Selected are not present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Validates Add Filter options are present on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Product Checkbox on Work Queue Task page
    And Types Product "2000" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Qty Checkbox on Work Queue Task page
    And Types Qty "1" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks From Checkbox on Work Queue Task page
    And Types From "101.113.90" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks To Checkbox on Work Queue Task page
    And Types To "101.113.70" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Type Checkbox on Work Queue Task page
    And Checks Movement Checkbox on Work Queue Task page
    And Clicks Task list title on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
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
    And Types Status "Count Pending" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Assignment Number Checkbox on Work Queue Task page
    And Types Assignment # "54557" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Priority Checkbox on Work Queue Task page
    And Types Priority "Normal" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Route Checkbox on Work Queue Task page
    And Types Route "__21144" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Stop Checkbox on Work Queue Task page
    And Types Stop "1" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Shipper Checkbox on Work Queue Task page
    And Types Shipper "180" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Velocity Checkbox on Work Queue Task page
    And Types Velocity "B" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And User clicks Clear All button on Work Queue Task page
    And User clicks Add filter button on Work Queue Task page
    And Checks Description Checkbox on Work Queue Task page
    And Types Description "PREMIUM MEDIUM GRAIN RICE (40# NEW)" on Work Queue Task page
    And Clicks Apply Button on Work Queue Task page
    And Validates Grid items are present on Work Queue Task page