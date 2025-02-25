@Setup @Regression
Feature: Fatigue

  Scenario: Verify Search field on Fatigue screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Labor
    And  Click on Search field on Fatigue Page
    Then Verify Search functionalities on Fatigue Page
    And  Verify remove icon on Fatigue Page
    And  Verify Search functionality with non existing search keyword on Fatigue Page