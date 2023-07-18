@WorkQueue @Regression
Feature: Testing of Work Queue User history functionality

  Scenario: Checking Navigate to Work Queue User history screen functionality
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Work Queue User history page
    And Waits for Work Queue User History page to load
    And Validates User history is displayed on Work Queue User History page
    And Validates Login, Logout, User id and Username columns are displayed on Work Queue User History page
    And Validates Grid items are present on Work Queue User History page
    And User scrolls till end of grid table on Work Queue User History page
    And Validates Table End is displayed on Work Queue User History page
    And User searches for "USER1" on Work Queue User History page
    And Validates Grid items are present on Work Queue User History page
    And User clears Search on Work Queue User History page
    And User clicks on Login Header on Work Queue User History page
    And Validates Login Column Sorting Result on Work Queue User History page
    And User clicks on Login Header on Work Queue User History page
    And Validates Login Column Sorting Result on Work Queue User History page
    And User clicks on Logout Header on Work Queue User History page
    And Validates Logout Column Sorting Result on Work Queue User History page
    And User clicks on Logout Header on Work Queue User History page
    And Validates Logout Column Sorting Result on Work Queue User History page
    And User clicks on User Id Header on Work Queue User History page
    And Validates User Id Column Sorting Result on Work Queue User History page
    And User clicks on User Id Header on Work Queue User History page
    And Validates User Id Column Sorting Result on Work Queue User History page
    And User clicks on User Name Header on Work Queue User History page
    And Validates User Name Column Sorting Result on Work Queue User History page
    And User clicks on User Name Header on Work Queue User History page
    And Validates User Name Column Sorting Result on Work Queue User History page

