@Setup @Regression
Feature: Setup Labor
  Scenario: Test Scenario for searching labor codes
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Labor
    And  Verify Search functionality
    And  Verify remove icon
    And  Verify Search functionality with non existing search keyword
#    And  Select User DropDown List
