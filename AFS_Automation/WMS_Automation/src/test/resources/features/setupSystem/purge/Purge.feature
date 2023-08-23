@Setup @Regression
Feature: SetupSystem

  Scenario: Verify Search field on Purge screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and System
    And  Click on Search field on Purge Page
    Then Verify Search functionalities2
    And  Verify remove icon2
    And  Verify Search functionality with non existing search keyword2