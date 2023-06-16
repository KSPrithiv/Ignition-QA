@Outbound @Regression
Feature: Testing of Outbound Summary Work functionality

  Scenario: Checking Work Assignments functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Filling start date "12/01/2021" and end date "02/22/2022" on Outbound Order Summary page
    And Verifies Work Item is disabled
    Then Selects order "CO00001442" on Outbound Order Summary page
    And Verifies Work Item is enabled
    And User selects work item on Outbound Order Summary page
    And Waits for Work Queue Page to load
    And Verifies Work Queue is displayed
    And Validates Assignment and Tasks tabs are displayed
    And Validates Assignment tab is active
    And Validates Work Queue order "S00001442" is displayed
    And Validates Edit, Delete, Release, Labels and Move are disabled
    And Validates Order "S00001442" assignments are displayed
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

  Scenario: Checking Work Assignments Tasks functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Filling start date "12/01/2021" and end date "02/22/2022" on Outbound Order Summary page
    And Verifies Work Item is disabled
    Then Selects order "CO00001442" on Outbound Order Summary page
    And Verifies Work Item is enabled
    And User selects work item on Outbound Order Summary page
    And Waits for Work Queue Page to load
    And Verifies Work Queue is displayed
    And Validates Assignment and Tasks tabs are displayed
    And Validates Assignment tab is active
    And User selects Tasks item on Outbound Order Summary page
    And User selects first task on Outbound Order Summary page
    And Validates Edit, Delete, TopOff, Move and Reprocess are displayed
    And Validates Assignments are present
