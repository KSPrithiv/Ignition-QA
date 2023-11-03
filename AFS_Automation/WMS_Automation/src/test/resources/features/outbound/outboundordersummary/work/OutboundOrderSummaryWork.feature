@Outbound @Regression
Feature: Testing of Outbound Summary Work functionality
  @isofailed
  Scenario: Checking Work Assignments functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Verifies Work Item is disabled
    Then Selects order by index 0 on Outbound Order Summary page
    And Verifies Work Item is enabled
    And User selects work item on Outbound Order Summary page
    And Waits for Work Queue Page to load
    And Verifies Work Queue is displayed
    And Validates Assignment and Tasks tabs are displayed
    And Validates Assignment tab is active
    And Validates Work Queue order by index 0 is displayed
    And Validates Edit, Delete, Release, Labels and Move are disabled
    And Validates Edit, Delete, Release, Labels and Move are displayed
    And User selects first assignment on Outbound Order Summary page
    And Validates Edit, Delete, Release, Labels and Move are enabled
    And User clicks Add filter button on Outbound Order Summary page
    And Validates Filter options are displayed
    And Validates Assignment columns are present
    And Validates Assignments are present
    And User clicks Add filter button on Outbound Order Summary page
    And Clicks Edit item on Outbound Order Summary page
    And Validates Assignments Edit popup title
    And Validates Assignments type dropdown is not empty
    And User clicks Assignment Type on Outbound Order Summary page
    And Validates Assignments types are present
    And Validates Edit Assignment popup contains all elements
    And Click Cancel button on Outbound Order Summary page

  @isofailed
  Scenario: Checking Work Assignments Tasks functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    When Filling start date by index 2 on Outbound Order Summary page
    And Verifies Work Item is disabled
    Then Selects order by index 0 on Outbound Order Summary page
    And Verifies Work Item is enabled
    And User selects work item on Outbound Order Summary page
    And Waits for Work Queue Page to load
    And Verifies Work Queue is displayed
    And Validates Assignment and Tasks tabs are displayed
    And Validates Assignment tab is active
