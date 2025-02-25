@Setup @Regression
Feature: JobType

  Scenario: Verify Search field on Shift screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Labor
    And  Click on Search field on Shift Page
    Then Verify Search functionalities on Shift Page