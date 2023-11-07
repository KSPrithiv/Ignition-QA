@Outbound @Regression
Feature: Testing of Outbound Route Summary Work option
  Scenario: Checking Work Route Assignments functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    And Validates Outbound Route Summary page is displayed
    And Validates Outbound Route Summary dates on Outbound Route Summary page
    When Filling route start date by index 2 on Outbound Route Summary page
    And Click on route with index 0 on Outbound Route Summary page
    And Validates work item is active on Outbound Route Summary page
    And Click Back button on Outbound Route Summary page
    And Selects route with index 0 on Outbound Route Summary page
    And Validates work item is active on Outbound Route Summary page
    Then User selects work item on Outbound Route Summary page
    And Validates Assignments tab and Tasks tab are displayed on Outbound Route Summary page
    And Validates Assignments tab is active by default on Outbound Route Summary page
    And Validates Assignment Type filter is displayed on Outbound Route Summary page
    And Selects Tasks Tab on Outbound Route Summary page
    And Validates Types Tab is displayed on Outbound Route Summary page
    And User clicks Assignments tab on Outbound Route Summary page
    And Validates Assignment Items Count is displayed on Outbound Route Summary page
    And Validates Assignment Items is displayed on Outbound Route Summary page
    And Validates Assignment tab options are displayed on Outbound Route Summary page
    And Clicks Add filter button on Outbound Route Summary page
    And Validates that Add Filter options for Assignments are displayed on Outbound Route Summary page
    And Validates Assignments table columns are present on Outbound Route Summary page
    And Validates Assignment Items Count is displayed on Outbound Route Summary page
    And Validates Assignment Items is displayed on Outbound Route Summary page
    And Validates Assignment Type filter is displayed on Outbound Route Summary page
    And Validates Assignments block is present on Outbound Route Summary page
    And Click on Assignment type dropdown on Outbound Route Summary page
    And Validates Assignment types are present on Outbound Route Summary page
    And Click on Task group dropdown on Outbound Route Summary page
    And Validates Task groups are present on Outbound Route Summary page
    And Click on Status tab dropdown on Outbound Route Summary page
    And Validates Statuses are present on Outbound Route Summary page

  Scenario: Checking Work Route Tasks functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Route page
    And Waits for Outbound Route Summary page to load
    When Filling route start date by index 2 on Outbound Route Summary page
    And Selects route with index 2 on Outbound Route Summary page
    And Validates work item is active on Outbound Route Summary page
    And User selects work item on Outbound Route Summary page
    And Validates Assignments tab and Tasks tab are displayed on Outbound Route Summary page
    And Validates Assignments tab is active by default on Outbound Route Summary page
    Then Selects Tasks Tab on Outbound Route Summary page
    And Validates Types Tab is displayed on Outbound Route Summary page
    And Validates Tasks Items is displayed on Outbound Route Summary page
    And Validates Tasks Items Count is displayed on Outbound Route Summary page
    And Selects Task checkbox by index 0 on Outbound Route Summary page
    And Validates Route Title is displayed on Outbound Route Summary page
    And Validates Tasks options Edit, Delete, Move and Reprocess are enabled on Outbound Route Summary page
    And Selects Task checkbox by index 0 on Outbound Route Summary page
    And Validates Tasks options Edit, Delete, Move and Reprocess are disabled on Outbound Route Summary page
    And Clicks Add filter button on Outbound Route Summary page
    And Validates that Add Filter options for Tasks are displayed on Outbound Route Summary page
    And Validates Task table columns are present on Outbound Route Summary page
    And Validates Tasks Items Count is displayed on Outbound Route Summary page
    And Validates Tasks Items is displayed on Outbound Route Summary page
    And Clicks All Tasks checkbox on Outbound Route Summary page
    And Validates selected Tasks Items is displayed on Outbound Route Summary page
    And Validates Tasks Reprocess is enabled on Outbound Route Summary page
    And Clicks All Tasks checkbox on Outbound Route Summary page
    And Validates Tasks options Edit, Delete, Move and Reprocess are disabled on Outbound Route Summary page
    And Selects Task checkbox by index 0 on Outbound Route Summary page
    And Clicks Edit option on Tasks tab page
    And Verifies Edit Task window is displayed on Outbound Route Summary page
    And Verifies Quantity field of Edit task window is displayed on Outbound Route Summary page
    And Verifies Quantity input of Edit task window is not empty on Outbound Route Summary page
    And Verifies Priorities field of Edit task window is displayed on Outbound Route Summary page
    And Verifies Priorities input "Normal" value of Edit task window on Outbound Route Summary page
    And Verifies Reason field of Edit task window is displayed on Outbound Route Summary page
    And Verifies Group field of Edit task window is displayed on Outbound Route Summary page
    And Verifies From Location field of Edit task window is displayed on Outbound Route Summary page
    And Verifies Pallets field of Edit task window is displayed on Outbound Route Summary page
    And Clicks Save button on Outbound Route Summary page