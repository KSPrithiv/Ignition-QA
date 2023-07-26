@Setup @Regression
Feature: ExitReason

  Scenario: Verify Search field on ExitReason screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Labor
    And  Click on Search field on ExitReason Page
    Then Verify Search functionalities on ExitReason Page
    And  Verify remove icon on ExitReason Page
    And  Verify Search functionality with non existing search keyword on ExitReason Page