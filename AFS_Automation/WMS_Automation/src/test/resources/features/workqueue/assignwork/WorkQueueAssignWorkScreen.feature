@WorkQueue @Regression
Feature: Testing of Work Queue Assign Work functionality
  Scenario: Checking Navigate to Work Queue Assign Work screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Work Queue Assign Work page
    And Waits for Work Queue Work Assign page to load
    And Validates Assign work screen is displayed on Work Queue Work Assign Page
    When Selects Task Group by index 0 on Work Queue Work Assign page
    And Validates Loading Task Group is displayed on Work Queue Work Assign Page
    And Validates list of users and user groups is displayed on Work Queue Work Assign Page
    And Checks user by index 5 on Work Queue Work Assign page
    Then Clicks Save Button on Work Queue Work Assign page
    And Clicks Cancel Button on Work Queue Work Assign page
    And Validates list of users and user groups is not displayed on Work Queue Work Assign Page

  Scenario: Checking User Group Filtering Assign Work Screen functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Work Queue Assign Work page
    And Waits for Work Queue Work Assign page to load
    And Validates Assign work screen is displayed on Work Queue Work Assign Page
    When Selects Task Group by index 3 on Work Queue Work Assign page
    And Validates Shipping Task Group is displayed on Work Queue Work Assign Page
    And Validates list of users and user groups is displayed on Work Queue Work Assign Page
    And Clicks Filter Button on Work Queue Work Assign page
    Then Clicks User Group Checkbox on Work Queue Work Assign page
    And Checks Managers User Group on Work Queue Work Assign page
    And Checks Operators User Group on Work Queue Work Assign page
    And Validates list of users and user groups is displayed on Work Queue Work Assign Page
    And User clicks Clear All button on Work Queue Work Assign page
    And Validates list of users and user groups is displayed on Work Queue Work Assign Page