@Setup @Regression
Feature: Congestion

  Scenario: Verify Search field on Congestion screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Labor
    And  Click on Search field on Congestion Page
    Then Verify Search functionalities on Congestion Page
    And  Verify remove icon on Congestion Page
    And  Verify Search functionality with non existing search keyword on Congestion Page